# Gunakan R untuk visualisasi
# install.packages("ggplot2") jika belum terinstal
library(ggplot2)

# Buat data untuk fungsi f(x)
x_vals <- seq(-3, 3, 0.1)
f_x <- x_vals^2 - 1
data <- data.frame(x = x_vals, y = f_x)

# Titik potong
titik <- data.frame(x = -1, y = 0)

# Garis singgung: y = -2x - 2
tangent <- data.frame(x = x_vals, y = -2 * x_vals - 2)

# Garis normal: y = 0.5x + 0.5
normal <- data.frame(x = x_vals, y = 0.5 * x_vals + 0.5)

# Plot
ggplot(data, aes(x, y)) +
  geom_line(color = "blue", size = 1.2) +
  geom_line(data = tangent, aes(x, y), color = "red", linetype = "dashed") +
  geom_line(data = normal, aes(x, y), color = "green", linetype = "dotted") +
  geom_point(data = titik, aes(x, y), color = "black", size = 3) +
  labs(
    title = "Kurva f(x), Garis Singgung & Garis Normal di x = -1",
    x = "x",
    y = "y"
  ) +
  theme_minimal()
