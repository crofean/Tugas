# install.packages("shiny")
# install.packages("plotly")
# install.packages("DT")

library(shiny)
library(plotly)
library(DT)

# Load data
data <- read.csv("weatherweather_data.csv")

# UI
ui <- fluidPage(
  titlePanel("Visualisasi Data Interaktif - Cuaca"),
  sidebarLayout(
    sidebarPanel(
      selectInput("xvar", "Pilih Variabel X:", choices = names(data)),
      selectInput("yvar", "Pilih Variabel Y:", choices = names(data)),
      radioButtons("plotType", "Pilih Jenis Visualisasi:",
                   choices = c("Scatter Plot" = "scatter",
                               "Line Plot" = "line",
                               "Bar Plot" = "bar",
                               "Tabel Data" = "table"))
    ),
    mainPanel(
      conditionalPanel(
        condition = "input.plotType == 'table'",
        DTOutput("dataTable")
      ),
      conditionalPanel(
        condition = "input.plotType != 'table'",
        plotlyOutput("plot")
      )
    )
  )
)

# Server
server <- function(input, output) {
  # Membuat reaktif untuk mendapatkan data yang dipilih
  selectedData <- reactive({
    req(input$xvar, input$yvar)
    list(
      x = data[[input$xvar]],
      y = data[[input$yvar]],
      xname = input$xvar,
      yname = input$yvar
    )
  })
  
  output$plot <- renderPlotly({
    # Get data yang dipilih
    sdata <- selectedData()
    
    # Membuat plot berdasarkan jenis visualisasi yang dipilih
    if (input$plotType == "scatter") {
      p <- plot_ly(data = data, 
                   x = ~get(input$xvar), 
                   y = ~get(input$yvar),
                   type = 'scatter', 
                   mode = 'markers') %>%
           layout(xaxis = list(title = sdata$xname),
                  yaxis = list(title = sdata$yname))
    } else if (input$plotType == "line") {
      p <- plot_ly(data = data, 
                   x = ~get(input$xvar), 
                   y = ~get(input$yvar),
                   type = 'scatter', 
                   mode = 'lines') %>%
           layout(xaxis = list(title = sdata$xname),
                  yaxis = list(title = sdata$yname))
    } else if (input$plotType == "bar") {
      p <- plot_ly(data = data, 
                   x = ~get(input$xvar), 
                   y = ~get(input$yvar),
                   type = 'bar') %>%
           layout(xaxis = list(title = sdata$xname),
                  yaxis = list(title = sdata$yname))
    }
    p
  })

  output$dataTable <- renderDT({
    datatable(data)
  })
}

# Run app
shinyApp(ui = ui, server = server)
