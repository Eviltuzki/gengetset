package top.eviltuzki.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class CamelToUnderline extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        try {
            Editor editor = e.getData(DataKeys.EDITOR);
            SelectionModel model = editor.getSelectionModel();
            String text = model.getSelectedText();
            String result = camelToUnderline(text);
            Document document = editor.getDocument();
            WriteCommandAction.runWriteCommandAction(e.getProject(), new Runnable() {
                @Override
                public void run() {
                    document.replaceString(model.getSelectionStart(), model.getSelectionEnd(), result);
                }
            });
        } catch (Exception ex) {
            //ignore
        }
    }

    private static final char UNDERLINE = '_';

    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
            }
            sb.append(Character.toLowerCase(c));  //统一都转小写
        }
        return sb.toString();
    }
}
