<?php

$con = mysqli_connect("localhost", "rsam", "password", "pendidikan");
if (mysqli_connect_errno()) {
    echo "Koneksi database gagal: " . mysqli_connect_error();
    exit();
}

$data = mysqli_query($con, "SELECT * FROM mahasiswa");
if (!$data) {
    echo "Query gagal: " . mysqli_error($con);
    exit();
}

// var_dump($data->fetch_all(MYSQLI_ASSOC));

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tugas 3</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #2c3e50;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            background-color: #ecf0f1;
            margin: 5px 0;
            padding: 10px;
            border-radius: 5px;
        }  
        p {
            font-size: 1.1em;
        }
    </style>
</head>
<body>
    <div>
        <h1>Data Mahasiswa</h1>
        <p>Berikut adalah data mahasiswa yang berhasil diambil dari database:</p>
        <ul>
            <?php
            mysqli_data_seek($data, 0); // Reset pointer ke awal
            while ($row = mysqli_fetch_assoc($data)) {
                echo "<li>" . $row['nim'] . " - " . $row['nama'] . " - " . $row['alamat'] . "</li>";
            }
            ?>
        </ul>
        <p>Jumlah mahasiswa: <?php echo mysqli_num_rows($data); ?></p>
    </div>
</body>
</html>