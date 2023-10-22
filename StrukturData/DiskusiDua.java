package StrukturData;

class DiskusiDua {
    public static void main(String[] args) {
        String[][] dataRuang = {
            {"Ruang 1", "Ruang 2", "Ruang 3"},
            {"Ruang 4", "Ruang 5", "Ruang 5"}
        };
        System.out.println(dataRuang[0][0]+"\n");
        
        int[][] dataNilai = new int[3][3];
        dataNilai[0][0] = 85;
        dataNilai[0][1] = 80;
        dataNilai[0][2] = 90;

        for (int i = 0; i < dataNilai.length; i++) {
            System.out.println(dataNilai[0][i]);
        }
    }
}
