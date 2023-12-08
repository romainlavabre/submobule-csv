package org.romainlavabre.csv;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
public class Csv {


    public static CsvFile parse( String csvContent ) {
        return new CsvParser().parse( csvContent );
    }


    public static CsvFile parse( byte[] csvContent ) {
        return parse( new String( csvContent, StandardCharsets.UTF_8 ) );
    }


    public static CsvFile parse( File csvFile ) {
        try {
            return parse( Files.readAllBytes( csvFile.toPath() ) );
        } catch ( IOException e ) {
            e.printStackTrace();
            return null;
        }
    }
}