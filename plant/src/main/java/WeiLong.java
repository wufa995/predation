/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

/**
 * @description: 例子
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1 16:08
 * @version: V1.0
 */
public class WeiLong {

    public static void main(String[] args) {
        String cssString = ".main{ width:100px;      top:0;}    #aaaa{name:  666}     scdasdad{ceshi :   8888888}";
        for(String targetStyleString : cssString.split("}")) {
            targetStyleString = targetStyleString.trim();
            String target = targetStyleString.substring(0, targetStyleString.indexOf("{"));
            target = target.trim();

            targetStyleString = targetStyleString.replace("{", ";");
            targetStyleString = targetStyleString.replace("}", ";");
            targetStyleString = targetStyleString.replace("\\n", "");
            targetStyleString = targetStyleString.replace("\\r", "");
            for(String str : targetStyleString.split(";")) {
                if(str.contains(":")) {
                    str = str.trim();
                    String name = str.substring(0, str.indexOf(":")).trim();
                    String value = str.substring(str.indexOf(":") + 1).trim();
                    System.out.println(target + " " + name + " " + value);
                }
            }
        }
    }
}
