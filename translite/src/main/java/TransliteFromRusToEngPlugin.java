import com.sun.tools.xjc.BadCommandLineException;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.outline.Outline;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

public class TransliteFromRusToEngPlugin extends Plugin {

    @Override
    public String getOptionName() {
        return "rus-translit";
    }

    @Override
    public String getUsage() {
        return "-rus-translit  :  for xml name";
    }

    @Override
    public void onActivated(Options opts) throws BadCommandLineException {
        opts.setNameConverter(new LanguageConverter(), this);
    }

    @Override
    public boolean run(Outline outline, Options options, ErrorHandler errorHandler) throws SAXException {
        return true;
    }
}
