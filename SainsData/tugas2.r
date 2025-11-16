data <- read.csv("/home/me/Campus/Semester7/SainsData/data.csv", sep = ";")

# Berdasarkan data medis tentang perkembangan penyakit setelah satu tahun amatan (Y), usia dalam tahun (AGE), low-density lipoproteins (LDL), high-density lipoproteins (HDL), total cholestero/HDL (TCH), triglycerides (LTG), dan blood sugar (GLU) sebagaimana terlampir, lakukan analisis statistik deskriptif untuk variabel Y dan GLU dengan cara: 

# 1. Buatlah visualisasi data bivariat menggunakan Scatter Plot 
# 2. Tuliskan model persamaan regresi linear dan estimasinya  
# 3. Buatlah rumusan masalah asosiatif berdasarkan visual data yang ada 
# 4. Berikan ulasan Anda tentang model dan hasil yang akan dicapal. 

# Load necessary libraries
library(ggplot2)
library(dplyr)
library(tidyr)
library(broom)
library(gridExtra)

# Extract Y and GLU data
if (!all(c("Y", "GLU") %in% colnames(data))) {
  stop("Kolom Y atau GLU tidak ditemukan dalam data.")
}

y_data <- data$Y
glu_data <- data$GLU
bivariate_data <- data.frame(Y = y_data, GLU = glu_data)
bivariate_data <- na.omit(bivariate_data)  # Remove NA values
n <- nrow(bivariate_data)
sorted_data <- bivariate_data[order(bivariate_data$GLU), ]

# 1. Visualisasi Data Bivariat menggunakan Scatter Plot
scatter_plot <- ggplot(bivariate_data, aes(x = GLU, y = Y)) +
  geom_point(color = "blue", alpha = 0.6) +
  labs(title = "Scatter Plot of Y vs GLU", x = "Blood Sugar (GLU)", y = "Disease Progression (Y)") + 
    theme_minimal()
print(scatter_plot)

# 2. Model Persamaan Regresi Linear dan Estimasinya
regression_model <- lm(Y ~ GLU, data = bivariate_data)
regression_summary <- summary(regression_model)
regression_equation <- paste("Y =", round(coef(regression_model)[1], 2), "+", round(coef(regression_model)[2], 2), "* GLU")

cat("Model Persamaan Regresi Linear:\n")
cat(regression_equation, "\n\n")
cat("Ringkasan Regresi:\n")
print(regression_summary)

# 3. Rumusan Masalah Asosiatif berdasarkan Visual Data
cat("\nRumusan Masalah Asosiatif:\n")
cat("Apakah terdapat hubungan yang signifikan antara kadar blood sugar (GLU) dengan perkembangan penyakit (Y)?\n")

# 4. Ulasan tentang Model dan Hasil yang Dicapai
cat("\nUlasan tentang Model dan Hasil:\n")
cat("Berdasarkan scatter plot, terdapat pola yang menunjukkan hubungan antara GLU dan Y.
Jika koefisien regresi untuk GLU signifikan (p-value < 0.05), maka dapat disimpulkan bahwa terdapat hubungan yang signifikan antara kadar blood sugar dan perkembangan penyakit 
pada pasien. Model regresi linear ini dapat digunakan untuk memprediksi perkembangan penyakit berdasarkan kadar blood sugar. Namun, perlu diingat bahwa korelasi tidak selalu berarti kausalitas, sehingga analisis lebih lanjut mungkin diperlukan untuk memahami mekanisme di balik hubungan ini.\n")

