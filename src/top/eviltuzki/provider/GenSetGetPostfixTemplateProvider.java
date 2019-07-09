package top.eviltuzki.provider;

import com.intellij.codeInsight.template.postfix.templates.JavaPostfixTemplateProvider;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import top.eviltuzki.template.GenGetSetTemplate;
import top.eviltuzki.template.GenSetTemplate;

import java.util.Set;

public class GenSetGetPostfixTemplateProvider extends JavaPostfixTemplateProvider {

    private final Set<PostfixTemplate> templates;

    public GenSetGetPostfixTemplateProvider() {
        GenGetSetTemplate genGetSetTemplate = new GenGetSetTemplate();
        GenSetTemplate genSetTemplate = new GenSetTemplate();
        templates = ContainerUtil.newHashSet(genGetSetTemplate,genSetTemplate);
    }

    @NotNull
    @Override
    public Set<PostfixTemplate> getTemplates() {
        return templates;
    }
}