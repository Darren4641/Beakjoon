public class test {

    public static void main(String[] args) {
        int a = 320 / 60;
        int b = 320 % 60;
        StringBuffer sb = new StringBuffer();
        String hour = String.valueOf(a);
        if(hour.length() < 2)
            sb.append("0");
        sb.append(hour);
        sb.append(":");
        String minutes = String.valueOf(b);
        if(minutes.length() < 2)
            sb.append("0");
        sb.append(minutes);
        System.out.println(sb.toString());
    }
}
