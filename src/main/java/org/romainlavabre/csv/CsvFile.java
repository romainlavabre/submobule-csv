package org.romainlavabre.csv;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
public class CsvFile {

    private List< String > heads;

    private final List< CsvRow > rows;


    public CsvFile() {
        rows = new ArrayList<>();
    }


    public List< String > getHeads() {
        return heads;
    }


    public void setHeaders( List< String > heads ) {
        this.heads = heads;
    }


    public List< CsvRow > getRows() {
        return rows;
    }


    public void addRow( List< String > row ) {
        rows.add( new CsvRow( row ) );
    }


    public byte[] toByteArray() {
        StringJoiner row = new StringJoiner( "\n" );

        StringJoiner head = new StringJoiner( "," );

        for ( String localHead : heads ) {
            head.add( localHead );
        }

        row.add( head.toString() );

        for ( CsvRow csvRow : rows ) {
            StringJoiner columns = new StringJoiner( "," );

            for ( String column : csvRow.get() ) {
                columns.add( column );
            }

            row.add( columns.toString() );
        }

        return row.toString().getBytes();
    }


    public class CsvRow {
        private final List< String > content;


        public CsvRow( List< String > row ) {
            content = row;
        }


        public String getFromHead( String head ) {
            int index = heads.indexOf( head );

            if ( index == -1 ) {
                return null;
            }

            if ( content.size() - 1 < index ) {
                return "";
            }

            return content.get( index );
        }


        public List< String > get() {
            return content;
        }
    }
}
