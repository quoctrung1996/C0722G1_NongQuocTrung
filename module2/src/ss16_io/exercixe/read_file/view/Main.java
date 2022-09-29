package ss16_io.exercixe.read_file.view;

import ss16_io.exercixe.copy_file_text.ReadAndWriteFile;
import ss16_io.exercixe.read_file.service.CountryService;

public class Main {
    public static void main(String[] args) {
        CountryService.getInfoCounttry(CountryService.readFile("src/ss16_io/exercixe/read_file/data/country.csv"));

    }
}
