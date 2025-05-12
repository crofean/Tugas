# Membaca data dari file CSV
mobil <- read.csv("mobil.csv")

# a. Rata-rata kecepatan mobil
rata_rata_kecepatan <- mean(mobil$Kecepatan)
print(paste("Rata-rata kecepatan mobil:", rata_rata_kecepatan))

# b. Rata-rata jarak yang ditempuh mobil
rata_rata_jarak <- mean(mobil$Jarak)
print(paste("Rata-rata jarak mobil:", rata_rata_jarak))

# # c. Standar deviasi jarak yang ditempuh mobil
standar_deviasi_jarak <- sd(mobil$Jarak)
print(paste("Standar deviasi jarak mobil:", standar_deviasi_jarak))

# # Membuat scatter plot Kecepatan vs Jarak
plot(mobil$Kecepatan, mobil$Jarak,
     main = "Scatter Plot Kecepatan vs Jarak",
     xlab = "Kecepatan (km/h)",
     ylab = "Jarak (meter)",
     pch = 19, col = "blue")

# # # Membuat histogram kecepatan
hist(mobil$Kecepatan,
     main = "Histogram Kecepatan Mobil",
     xlab = "Kecepatan (km/h)",
     col = "lightblue",
     border = "black",
     breaks = 10)

# Thomas memperoleh nilai 80 untuk ujian Matematika 
# dengan rata
# -rata kelas 75 dan standar deviasi 10. Untuk 
# ujian bahasa Inggris, Thomas memperoleh nilai 75 
# dengan rata
# -rata kelas 70 dan standar deviasi 8. 
# Hitunglah koefisien keragaman untuk nilai ujian 
# Matematika dan bahasa Inggris Thomas


# # Membuat koefisien keragaman
cvMath <- 10 / 75 * 100
cvEnglish <- 8 / 70 * 100
print(paste("Koefisien keragaman Matematika:", cvMath))
print(paste("Koefisien keragaman Bahasa Inggris:", cvEnglish))