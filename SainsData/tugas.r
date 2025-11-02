data <- read.csv("/home/me/Campus/Semester7/SainsData/data.csv", sep = ";")

# Check if data loaded successfully
if (nrow(data) == 0) {
  stop("Data tidak berhasil dimuat. Periksa path file CSV.")
}

# Berdasarkan data meds terlampir tentang perkembangan penyakit setelah satu tahun amatan
# (¥). usia dalam tahun (AGE), low-density lipoproteins (LDL), high-density lipoproteins (HDL), total
# cholesterol/HDL (TCH), triglycerides (LTG), dan blood sugar (GLU), lakukan analisis statistik
# deskriptif untuk variabel blood sugar (GLU) dengan cara:
# 1. Hitunglah ukuran pemusatan data: Mean, Median, dan Mode
# 2. Hitunglah ukuran penyebaran data: Range, Variance, dan Standard Deviation
# 3. Tentukan bentuk distribusi data: Symmetry, Skewness, dan Kurtosis.
# 4. Buatlah visualisasi data univariat menggunakan Quartile Plot (box plot) dan berikan ulasan tentang plot tersebut.

# Load necessary libraries
library(moments)
library(ggplot2)
library(dplyr)
library(modeest)
library(tidyr)
library(gridExtra)

# Extract GLU data
if (!("GLU" %in% colnames(data))) {
  stop("Kolom GLU tidak ditemukan dalam data.")
}

glu_data <- data$GLU
glu_data <- na.omit(glu_data)  # Remove NA values
n <- length(glu_data)
sorted_glu <- sort(glu_data)


# 1. Ukuran Pemusatan Data
mean_glu <- mean(glu_data)
median_glu <- median(glu_data)
mode_glu <- as.numeric(mlv(glu_data, method = "mfv"))


# 2. Ukuran Penyebaran Data
range_glu <- range(glu_data)
variance_glu <- var(glu_data)
sd_glu <- sd(glu_data)  


# 3. Bentuk Distribusi Data
skewness_glu <- moments::skewness(glu_data)
kurtosis_glu <- moments::kurtosis(glu_data)
symmetry_glu <- ifelse(abs(skewness_glu) < 0.5, "Symmetric", 
                        ifelse(skewness_glu > 0, "Positively Skewed", "Negatively Skewed"))
# Print results
cat("Ukuran Pemusatan Data:\n")
cat("Mean GLU:", mean_glu, "\n")
cat("Median GLU:", median_glu, "\n")
cat("Mode GLU:", mode_glu, "\n\n")

cat("Ukuran Penyebaran Data:\n")
cat("Range GLU:", range_glu, "\n")
cat("Variance GLU:", variance_glu, "\n")
cat("Standard Deviation GLU:", sd_glu, "\n\n")

cat("Bentuk Distribusi Data:\n")
cat("Skewness GLU:", skewness_glu, "\n")
cat("Kurtosis GLU:", kurtosis_glu, "\n")
cat("Symmetry GLU:", symmetry_glu, "\n")

# 4. Visualisasi Data Univariat menggunakan Box Plot
boxplot_glu <- ggplot(data, aes(y = GLU)) +
  geom_boxplot(fill = "lightblue", color = "darkblue") +
  labs(title = "Box Plot of Blood Sugar (GLU)", y = "Blood Sugar (GLU)") +
  theme_minimal()

# Print the box plot
print(boxplot_glu)

# Ulasan tentang plot tersebut
cat("\nUlasan Box Plot:\n")
cat("Box plot menunjukkan distribusi nilai GLU dengan median, kuartil, dan potensi outlier.\n")
cat("Median GLU ditandai oleh garis di tengah kotak, sedangkan kotak menunjukkan rentang interkuartil (IQR).\n")
cat("Garis horizontal di luar kotak menunjukkan rentang data, dan titik-titik di luar garis tersebut\n")
cat("menunjukkan potensi outlier. Jika ada banyak outlier, hal ini dapat menunjukkan variasi yang signifikan dalam data GLU.\n") 
cat("Selain itu, posisi median relatif terhadap kotak dapat memberikan indikasi tentang skewness data.\n")
