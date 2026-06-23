public class Main {
    public static void main(String[] args) {
        
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();

        Document pdf = pdfFactory.createDocument();

        pdf.open();


        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document excel =  excelFactory.createDocument();
        excel.open();
        System.out.println("Factory Method Pattern Implemented Successfully");
    }
}

// Document Interface
interface Document {

    void open();
}

// Word Document
class WordDocument implements Document {

    public void open() {

        System.out.println("Word Document Created");
    }
}

// PDF Document
class PdfDocument implements Document {

    public void open() {

        System.out.println("PDF Document Created");
    }
}

// Excel Document
class ExcelDocument implements Document {

    public void open() {

        System.out.println("Excel Document Created");
    }
}

// Abstract Factory
abstract class DocumentFactory {

    public abstract Document createDocument();
}
// Word Factory
class WordDocumentFactory extends DocumentFactory {

    public Document createDocument() {

        return new WordDocument();
    }
}
// PDF Factory
class PdfDocumentFactory extends DocumentFactory {

    public Document createDocument() {

        return new PdfDocument();
    }
}
// Excel Factory
class ExcelDocumentFactory extends DocumentFactory {

    public Document createDocument() {

        return new ExcelDocument();
    }
}
