package org.romainlavabre.csv;

import java.util.Arrays;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
class CsvParser {


    public CsvFile parse( String csvContent ) {
        final CsvFile  csvFile = new CsvFile();
        final String   comma   = getComma( csvContent );
        final String[] lines   = toLines( csvContent );

        for ( int i = 0; i < lines.length; i++ ) {
            String[] columns = lines[ i ].split( comma );

            if ( i == 0 ) {
                csvFile.setHeaders( Arrays.asList( columns ) );
                continue;
            }

            csvFile.addRow( Arrays.asList( columns ) );
        }

        return csvFile;
    }


    protected String getComma( String content ) {
        String[] simpleComma  = content.split( "," );
        String[] complexComma = content.split( ";" );

        return simpleComma.length > complexComma.length
                ? ","
                : ";";
    }


    protected String[] toLines( String content ) {
        return content.split( "\\n" );
    }
}
