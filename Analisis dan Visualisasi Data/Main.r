# Membaca data dari file CSV
mobil <- read.csv("mobil.csv")

# a. Rata-rata kecepatan mobil
rata_rata_kecepatan <- mean(mobil$Kecepatan)
print(paste("Rata-rata kecepatan mobil:", rata_rata_kecepatan))

# b. Rata-rata jarak yang ditempuh mobil
rata_rata_jarak <- mean(mobil$Jarak)
print(paste("Rata-rata jarak mobil:", rata_rata_jarak))

# c. Standar deviasi jarak yang ditempuh mobil
standar_deviasi_jarak <- sd(mobil$Jarak)
print(paste("Standar deviasi jarak mobil:", standar_deviasi_jarak))

# Membuat scatter plot Kecepatan vs Jarak
plot(mobil$Kecepatan, mobil$Jarak,
     main = "Scatter Plot Kecepatan vs Jarak",
     xlab = "Kecepatan (km/h)",
     ylab = "Jarak (meter)",
     pch = 19, col = "blue")

# Membuat histogram kecepatan
hist(mobil$Kecepatan,
     main = "Histogram Kecepatan Mobil",
     xlab = "Kecepatan (km/h)",
     col = "lightblue",
     border = "black",
     breaks = 10)

