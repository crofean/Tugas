# Instal paket berikut jika belum terinstal, lalu load paket 
# menggunakan fungsi library().
# chooseCRANmirror()

# install.packages("ggplot2")
# install.packages("dplyr")
# install.packages("broom")
# install.packages("ggpubr")
library(ggplot2)
library(dplyr)
library(broom)
library(ggpubr)

pendapatan <- read.csv("data_pendapatan.csv")

# Lakukan regresi linear sederhana dengan mengiktui langkah langkah berikut.
# a. Gunakan (plot) histogram untuk cek apakah variabel terikat
# berdistribusi normal atau tidak. Jelaskan interpretasi histogram 
# tersebut!

ggplot(pendapatan, aes(x = pendapatan)) +
  geom_histogram(binwidth = 1000, fill = "blue", color = "black") +
  labs(title = "Histogram Pendapatan", x = "Pendapatan", y = "Frekuensi") +
  theme_minimal()

# Gunakan scatter plot untuk cek apakah variabel terikat dan 
# bebas memiliki hubungan linear. Interpretasikan hasil grafik 
# tersebut! 
ggplot(pendapatan, aes(x = pendapatan, y = pendapatan)) +
  geom_point(color = "blue") +
  labs(title = "Scatter Plot Pendapatan", x = "Pendapatan", y = "Pendapatan") +
  theme_minimal()

# Lakukan regresi linear sederhana dan jelaskan hasil regresi 
# tersebut!

model <- lm(pendapatan ~ pendapatan, data = pendapatan)
summary(model)

# Gunakan perintah plot(nama variabel regresi kalian) untuk 
# cek homoskedastisitas. Interpretasikan hasil plot
plot(model)
# Homoskedastisitas adalah asumsi bahwa varians dari residual
# (selisih antara nilai yang diprediksi dan nilai aktual)
# adalah konstan di seluruh rentang nilai variabel independen.
# Jika plot residual terhadap nilai yang diprediksi menunjukkan
# pola acak tanpa pola yang jelas, maka asumsi homoskedastisitas
# terpenuhi. Namun, jika ada pola yang jelas (seperti pola
# berbentuk corong atau pola yang meningkat), maka asumsi ini
# mungkin dilanggar, yang dapat mempengaruhi validitas model regresi.
# Gunakan perintah ggqqplot(nama variabel regresi kalian) untuk
# cek normalitas residual. Interpretasikan hasil plot tersebut!
ggqqplot(model$residuals) +
  labs(title = "QQ Plot Residual Model", x = "Teoritis Quantiles", y = "Sample Quantiles")
# QQ plot digunakan untuk memeriksa apakah residual model regresi
# terdistribusi normal. Jika titik-titik pada QQ plot mengikuti
# garis diagonal, maka residual dianggap terdistribusi normal.
# Jika titik-titik menyimpang dari garis diagonal, maka asumsi
# normalitas mungkin dilanggar. Dalam hal ini, kita perlu
# mempertimbangkan transformasi data atau metode regresi yang
# lebih robust terhadap pelanggaran asumsi normalitas.
# Gunakan perintah ggresiduals(nama variabel regresi kalian) untuk
# cek apakah residual terdistribusi normal. Interpretasikan
# hasil plot tersebut!

# . Visualisasikan hasil regresi menggunakan grafik dengan 
# langkah-langkah berikut:
# 1. Plot data points pada grafik (10 poin)
# 2. Tambahkan garis regresi linear pada data yang sudah diplot
# (10 poin)
# 3. Tambah persamaan untuk garis linear (10 poin)
# 4. Beri judul dan label yang sesuai untuk sumbu x dan y (10 
# poin)

# Plot tiitk data
ggplot(data, aes(x = pendidikan, y = pendapatan)) +
  geom_point(color = "blue")

# Garis regresi linear
ggplot(data, aes(x = pendidikan, y = pendapatan)) +
  geom_point(color = "blue") +
  geom_smooth(method = "lm", color = "red")

# Persamaan regresi linear
ggplot(data, aes(x = pendidikan, y = pendapatan)) +
  geom_point(color = "blue") +
  geom_smooth(method = "lm", color = "red") +
  stat_regline_equation(label.y = max(data$pendapatan) * 0.9)

# Judul dan label sumbu
ggplot(data, aes(x = pendidikan, y = pendapatan)) +
  geom_point(color = "blue") +
  geom_smooth(method = "lm", color = "red") +
  stat_regline_equation(label.y = max(data$pendapatan) * 0.9) +
  labs(title = "Regresi Linear Pendapatan vs Pendidikan",
       x = "Pendidikan",
       y = "Pendapatan")