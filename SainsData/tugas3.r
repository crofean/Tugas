data <- read.csv("/home/me/Campus/Semester7/SainsData/data.csv", sep = ";")

# Berdasarkan data medis terlampir tentang perkembangan penyakit setelah satu tahun 
# amatan (Y), usia dalam tahun (AGE), low-density lipoproteins (LDL), high-density lipoproteins 
# (HDL), total cholesterol/HDL (TCH), triglycerides (TG), dan blood sugar (GLU). Jika ingin 
# lakukan analisis deskriptif untuk melihat pengaruh linear variabel AGE, LDL, dan HDL terhadap  Y dengan cara sebagai berikut. 

# 1. Buatlah visualisasi data multivariat menggunakan Scatter Plot variabel AGE, LDL, dan HDL terhadap Y 
# 2. Tentukan model persamaan regresi linear secara simultan dan parsial 
# 3. Berikan ulasan tentang model tersebut. 

# Load necessary libraries
library(ggplot2)
library(dplyr)
library(tidyr)
library(broom)
library(gridExtra)

# Extract relevant data
if (!all(c("Y", "AGE", "LDL", "HDL") %in% colnames(data))) {
  stop("Kolom Y, AGE, LDL, atau HDL tidak ditemukan dalam data.")
}

y_data <- data$Y
age_data <- data$AGE
ldl_data <- data$LDL
hdl_data <- data$HDL
multivariate_data <- data.frame(Y = y_data, AGE = age_data, LDL = ldl_data, HDL = hdl_data)
multivariate_data <- na.omit(multivariate_data)  # Remove NA values
n <- nrow(multivariate_data)
sorted_data <- multivariate_data[order(multivariate_data$AGE, multivariate_data$LDL, multivariate_data$HDL), ]

# 1. Visualisasi Data Multivariat menggunakan Scatter Plot
scatter_plot_age <- ggplot(multivariate_data, aes(x = AGE, y = Y)) +
  geom_point(color = "red", alpha = 0.6) +
  labs(title = "Scatter Plot of Y vs AGE", x = "Age (AGE)", y = "Disease Progression (Y)") + 
    theme_minimal()
scatter_plot_ldl <- ggplot(multivariate_data, aes(x = LDL, y = Y)) +
  geom_point(color = "green", alpha = 0.6) +
  labs(title = "Scatter Plot of Y vs LDL", x = "Low-Density Lipoproteins (LDL)", y = "Disease Progression (Y)") + 
    theme_minimal()
scatter_plot_hdl <- ggplot(multivariate_data, aes(x = HDL, y = Y)) +
  geom_point(color = "blue", alpha = 0.6) +
  labs(title = "Scatter Plot of Y vs HDL", x = "High-Density Lipoproteins (HDL)", y = "Disease Progression (Y)") + 
    theme_minimal()

grid.arrange(scatter_plot_age, scatter_plot_ldl, scatter_plot_hdl, ncol = 2)

# 2. Model Persamaan Regresi Linear secara Simultan dan Parsial
regression_model <- lm(Y ~ AGE + LDL + HDL, data = multivariate_data)
regression_summary <- summary(regression_model)
regression_equation <- paste("Y =", round(coef(regression_model)[1], 2), "+", 
                             round(coef(regression_model)[2], 2), "* AGE +", 
                             round(coef(regression_model)[3], 2), "* LDL +", 
                             round(coef(regression_model)[4], 2), "* HDL")  
cat("Model Persamaan Regresi Linear Simultan:\n")
cat(regression_equation, "\n\n")
cat("Ringkasan Regresi:\n")
print(regression_summary)

# 3. Ulasan tentang Model
cat("\nUlasan tentang Model:\n")
cat("Model regresi linear ini menunjukkan bagaimana variabel AGE, LDL, dan HDL secara simultan mempengaruhi perkembangan penyakit (Y). 
Koefisien regresi untuk masing-masing variabel independen menunjukkan perubahan rata-rata pada Y untuk setiap unit perubahan pada variabel tersebut, dengan asumsi variabel lainnya tetap konstan. 
Jika p-value untuk koefisien regresi signifikan (biasanya < 0.05), maka variabel tersebut memiliki pengaruh yang signifikan terhadap Y. 
Model ini dapat digunakan untuk memprediksi perkembangan penyakit berdasarkan usia dan kadar lipid dalam darah. Namun, perlu diingat 
bahwa model ini hanya menunjukkan hubungan linear dan tidak menyiratkan kausalitas. Analisis lebih lanjut mungkin diperlukan untuk memahami mekanisme di balik hubungan ini.\n")