package top.eviltuzki.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class UnderlineToCamel extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        try {
            Editor editor = e.getData(DataKeys.EDITOR);
            SelectionModel model = editor.getSelectionModel();
            String text = model.getSelectedText();
            String result = underlineToCamel(text);
            Document document = editor.getDocument();
            String documentText = document.getText();
            String replace = documentText.substring(0,model.getSelectionStart()) + result + documentText.substring(model.getSelectionEnd());
            document.setText(replace);
        }catch (Exception ex){
            //ignore
        }
    }

    public static final char UNDERLINE = '_';
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        Boolean flag = false; // "_" 后转大写标志,默认字符前面没有"_"
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                flag = true;
                continue;   //标志设置为true,跳过
            } else {
                if (flag == true) {
                    //表示当前字符前面是"_" ,当前字符转大写
                    sb.append(Character.toUpperCase(param.charAt(i)));
                    flag = false;  //重置标识
                } else {
                    sb.append(Character.toLowerCase(param.charAt(i)));
                }
            }
        }
        return sb.toString();
    }
}
