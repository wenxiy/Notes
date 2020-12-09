import javax.swing.*;

public class square {

    public static void main(String[] args) {
        double result = 0;
        boolean inputComplete = false;
        while (inputComplete == false) {
            String str = JOptionPane.showInputDialog(null, "输入一个正整数", "输入对话框", JOptionPane.PLAIN_MESSAGE);
            try {
                result = Double.parseDouble(str);
                if (result >= 0) inputComplete = true;
                if (result <= 0) throw new NumberFormatException();//对异常进行判断
            } catch (NumberFormatException exp) {
                JOptionPane.showMessageDialog(null, "非法字符", "警告对话框", JOptionPane.WARNING_MESSAGE);
                inputComplete = false;
            }
        }
        double sqrtRoot = Math.sqrt(result);
        System.out.println(result + "平方根" + sqrtRoot);
    }
}
