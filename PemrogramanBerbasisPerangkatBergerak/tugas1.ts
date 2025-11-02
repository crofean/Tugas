// Nama : Fadil Biyan Eka Satria
// NIM : 048634082
// Prodi : Sistem Informasi

// Tugas 1 Pemrograman Berbasis Perangkat Bergerak

// 1. Buatlah Pola Segitiga dari NIM, Ambil digit terakhir NIM Anda sebagai tinggi segitiga.
let nim: string = "048634082";
let tinggiSegitiga: number = parseInt(nim.charAt(nim.length - 1));
console.log("NIM: " + nim);
console.log(
  "Tinggi segitiga berdasarkan digit terakhir NIM: " + tinggiSegitiga
);

console.log("\nNomor 1: Pola Segitiga dari NIM");
console.log("Pola Segitiga dari NIM:");
for (let i = 1; i <= tinggiSegitiga; i++) {
  let baris: string = "";
  let startChar = 1;
  for (let j = 1; j <= i; j++) {
    baris += startChar + " ";
    startChar++;
  }
  console.log(baris.trim());
}
console.log("\n");

//  Buatlah Deret Aritmatika dengan NIM. Ambil 2 digit terakhir NIM, jadikan angka awal deret.
// Ambil digit ke-3 dari belakang, jadikan beda (step). Buat program TypeScript untuk mencetak
// 10 angka pertama dari deret aritmatika tersebut.

console.log("Nomor 2: Deret Aritmatika dari NIM");

let angkaAwal: number = parseInt(
  nim.charAt(nim.length - 2) + nim.charAt(nim.length - 1)
);

let beda: number = parseInt(nim.charAt(nim.length - 3));
console.log("Deret Aritmatika:");
for (let i = 0; i < 10; i++) {
  angkaAwal += beda + 1;
  console.log(angkaAwal);
}

console.log("\n");

// Buatlah Bilangan Prima dari NIM. Ambil 2 digit terakhir NIM dan tambahkan 10,
// jadikan batas akhir pencarian bilangan prima. Buat program TypeScript untuk menampilkan
// semua bilangan prima dari 1 sampai batas tersebut.

console.log("Nomor 3: Bilangan Prima dari NIM");

let batas: number =
  parseInt(nim.charAt(nim.length - 2) + nim.charAt(nim.length - 1)) + 10;

console.log("Bilangan Prima:");
for (let i = 2; i <= batas; i++) {
  let isPrima: boolean = true;
  for (let j = 2; j < i; j++) {
    if (i % j === 0) {
      isPrima = false;
      break;
    }
  }
  if (isPrima) {
    console.log(i);
  }
}

console.log("\n");
