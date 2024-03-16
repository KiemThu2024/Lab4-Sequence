package org.example;

import java.io.File;
import java.io.IOException;

public class JDependUIExporter {
    public static void main(String[] args) {
        String pathToXmlReportFile = "T:\\main\\main4\\reports\\report.xml";
        String packagesPrefix = "be";

        try {
            // Tạo một ProcessBuilder với lệnh và các đối số tương ứng
            ProcessBuilder builder = new ProcessBuilder("npm", "run", "jdepend-ui", pathToXmlReportFile, packagesPrefix);
            // Đặt thư mục làm việc cho ProcessBuilder (nếu cần)
            builder.directory(new File(System.getProperty("user.dir")));

            Process process = builder.start();
            process.waitFor();

            int exitValue = process.exitValue();
            if (exitValue == 0) {
                System.out.println("Chạy thành công. Bạn đã có file index.html trong thư mục làm việc.");
            } else {
                System.out.println("Có lỗi xảy ra khi chạy lệnh.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}