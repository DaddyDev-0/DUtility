package daddy.devmas.dutility.messages;

import com.github.vbauer.yta.model.Language;
import com.github.vbauer.yta.service.YTranslateApi;
import com.github.vbauer.yta.service.YTranslateApiImpl;
import daddy.devmas.dutility.DUtility;

public class Translator {

    private DUtility dUtility;
    private YTranslateApi translateApi;
    private boolean useTranslator;

    public Translator(DUtility dUtility) {
        this.dUtility = dUtility;
        translateApi = new YTranslateApiImpl(dUtility.getFiles().getConfig().getString("translator.api-key"));
        useTranslator = dUtility.getFiles().getConfig().getBoolean("translator.enable");

        if(useTranslator) {
            System.out.println("+------------------------- DUtility Translator -------------------------+");
            System.out.println(" ");
            System.out.println("You have the translator feature enabled. By using this feature, you acknowledge");
            System.out.println("the TOS that are outlined by Yandex here: https://translate.yandex.com/developers/offer");
            System.out.println(" ");
            System.out.println("You require a FREE api key from: https://translate.yandex.com/developers/keys");
            System.out.println(" ");
            System.out.println("+--------------------------------------------------+");
        }
    }

    public boolean enabled() { return useTranslator; }

    public void toggle() {
        this.useTranslator = !useTranslator;

        this.dUtility.getFiles().getConfig().set("translator.enable", this.useTranslator);
        this.dUtility.getFiles().saveConfig();
    }

    public String translate(String input, Language target) {
        Language source = translateApi.detectionApi().detect(input).orElse(null);

        if(useTranslator) {
            if(source != null && source.code().matches(target.code())) return input;
            else return translateApi.translationApi().translate(input, target).text();
        } else return input;
    }

    public Language getLanguageFromInput(String input) {
        return translateApi.detectionApi().detect(input).orElse(null);
    }

    public Language getLanguageFromCode(String code) {
        return Language.ALL.get(code);
    }
}
