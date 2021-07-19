public static void main(String[] args) {
        File file = new File("D:/idea练习");
        all(file);
    }
    private static void all(File file){
        File[] files = file.listFiles();
        for (File file1 : files){
            if (file1.isDirectory()) {
                all(file1);
            }else if (file1.isFile()) {
                String[] spkit = file1.getName().split("\\.");
                boolean aClass = spkit[spkit.length - 1].equals("class");
                boolean bClass = spkit[spkit.length - 1].equals("java");
                if (aClass||bClass) {
                    System.out.println("file1 = " + file1.toString());
                }
            }
        }
    }