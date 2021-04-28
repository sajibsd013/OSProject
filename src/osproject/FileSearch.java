package osproject;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import static java.nio.file.FileVisitOption.FOLLOW_LINKS;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FileSearch {

    static JTextArea area = new JTextArea();

    static void FS() {
        area.setEditable(false);
    }

    FileSearch(final String input, final String extentsion_check, final String drivePath) throws IOException {

        Path file = Paths.get(drivePath+"://");
        try {
            SimpleFileVisitor<Path> pathVisitor = new SimpleFileVisitor<Path>() {
                String check;

                @Override
                public FileVisitResult visitFileFailed(Path p, IOException e) {
                    area.setText("File not found!!. Please again\n ");
                    check = p.toString() + e.toString();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {

                    switch (extentsion_check) {
                        case "with_Extension": {

                            if (input.isEmpty()) {
                                area.setText("Please Enter file Path\n");
                                JOptionPane.showMessageDialog(null, "Please Enter file Path", "File Search", JOptionPane.ERROR_MESSAGE);
                                return FileVisitResult.TERMINATE;
                            } else if (!input.contains(".")) {
                                area.setText("Please Enter Path Extension or Invail Extension \n");
                                return FileVisitResult.TERMINATE;
                            } else if (file.getFileName().toString().endsWith(input)) {
                                if (!check.isEmpty()) {
                                    area.setText("");
                                    check = "";
                                }
                                area.append(file.toString() + "\n");
                                return FileVisitResult.CONTINUE;
                            } else {
                                return FileVisitResult.CONTINUE;
                            }
                        }

                        case "without_Extension": {

                            if (input.isEmpty()) {
                                area.setText("Please Enter file Path\n");
                                JOptionPane.showMessageDialog(null, "Please Enter file Path", "File Search", JOptionPane.ERROR_MESSAGE);
                                return FileVisitResult.TERMINATE;
                            } else if (input.contains(".")) {
                                area.setText("Please remove Path Extension \n");
                                return FileVisitResult.TERMINATE;
                            } else if (file.getFileName().toString().contains(input+".")) {
                                if (!check.isEmpty()) {
                                    area.setText("");
                                    check = "";
                                }
                                area.append(file.toString() + "\n");
                                return FileVisitResult.CONTINUE;
                            } else {
                                return FileVisitResult.CONTINUE;
                            }
                        }

                    }
                    return FileVisitResult.CONTINUE;

                }

            };
            EnumSet<FileVisitOption> option = EnumSet.of(FOLLOW_LINKS);
            Files.walkFileTree(file, option, 5, pathVisitor);
        } catch (Exception e) {

        }
    }

}
