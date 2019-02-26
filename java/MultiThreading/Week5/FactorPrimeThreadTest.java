//package Week5;
import org.junit.Test;
import java.math.BigInteger;

public class FactorPrimeThreadTest {

    @Test
    public void test1 () {
        BigInteger n = new BigInteger("4294967297");
        BigInteger result = new FactorThread().factorMultiThread(n);

        assert(result.intValue()==641 || result.intValue()==6700417);
    }

    @Test
    public void test2 () {
        BigInteger n = new BigInteger("239839672845043");
        BigInteger result = new FactorThread().factorMultiThread(n);
        assert(result.intValue()==15486047 || result.intValue()==15487469);
    }

    @Test
    public void test3 () {
        BigInteger n = new BigInteger("1127451830576035879");
        BigInteger result = new FactorThread().factorMultiThread(n);
        assert(result != null);
    }

    @Test
    public void testPerformance1() {
        BigInteger n = new BigInteger("4294967297");
        long startTime = System.currentTimeMillis();
        BigInteger one = new FactorPrimeThread(n, 4).factor();
        long duration = System.currentTimeMillis() - startTime;
        int seconds = (int) (duration / 1000) % 60 ;
        int minutes = (int) ((duration / (1000*60)) % 60);
        int hours   = (int) ((duration / (1000*60*60)) % 24);
        System.out.println("Time used: " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");
        assert(minutes<=1);
    }

    @Test
    public void testPerformance2() {
        BigInteger n = new BigInteger("239839672845043");
        long startTime = System.currentTimeMillis();
        BigInteger one = new FactorPrimeThread(n, 4).factor();
        long duration = System.currentTimeMillis() - startTime;
        int seconds = (int) (duration / 1000) % 60 ;
        int minutes = (int) ((duration / (1000*60)) % 60);
        int hours   = (int) ((duration / (1000*60*60)) % 24);
        System.out.println("Time used: " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");
        assert(minutes<=1);
    }

    @Test
    public void testPerformance3() {
        BigInteger n = new BigInteger("1127451830576035879");
        long startTime = System.currentTimeMillis();
        BigInteger one = new FactorPrimeThread(n, 4).factor();
        long duration = System.currentTimeMillis() - startTime;
        int seconds = (int) (duration / 1000) % 60 ;
        int minutes = (int) ((duration / (1000*60)) % 60);
        int hours   = (int) ((duration / (1000*60*60)) % 24);
        System.out.println("Time used: " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");
        assert(minutes<=2);
    }

    @Test
    public void testPerformance4() {
        BigInteger n = new BigInteger("160731047637009729259688920385507056726966793490579598495689711866432421212774967029895340327197901756096014299132623454583177072050452755510701340673282385647899694083881316194642417451570483466327782135730575564856185546487053034404560063433614723836456790266457438831626375556854133866958349817172727462462516466898479574402841071703909138062456567624565784254101568378407242273207660892036869708190688033351601539401621576507964841597205952722487750670904522932328731530640706457382162644738538813247139315456213401586618820517823576427094125197001270350087878270889717445401145792231674098948416888868250143592026973853973785120217077951766546939577520897245392186547279572494177680291506578508962707934879124914880885500726439625033021936728949277390185399024276547035995915648938170415663757378637207011391538009596833354107737156273037494727858302028663366296943925008647348769272035532265048049709827275179381252898675965528510619258376779171030556482884535728812916216625430187039533668677528079544176897647303445153643525354817413650848544778690688201005274443717680593899");
        //how do we assert that it would take more than minutes to finish factoring this number?
    }
}
