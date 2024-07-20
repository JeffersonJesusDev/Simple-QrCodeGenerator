package br.com.jeffdev.qrcodegenarator.demo.utils;

import br.com.jeffdev.qrcodegenarator.demo.model.student.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrCodeGenerator {

    public static void generateQRCode(Student student) throws WriterException, IOException {
        String qrCodePath = "C:\\Users\\JJ\\Desktop\\intelij-ws\\QrCode\\";
        String qrCodeName = qrCodePath + student.getFirstName() + student.getId() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID" + student.getId() + "\n" + "Firstname: " + "\n" +
                        "Lastname: " + student.getLastName() + "\n" +
                        "Email: " + student.getEmail() + "\n" +
                        "Mobile: " + student.getMobile(), BarcodeFormat.QR_CODE, 400, 400);

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);


    }
}
