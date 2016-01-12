package maker;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR: zhangbin
 * ON: 16/1/12
 */
public class MakerTest {
    private static final String makerHttpUrl = "";
    public static final String APPKEY = "";
    public static final String SECRET = "";
    private static Map<String, String> getSign(Map<String, Object> params) {
        String appKey = APPKEY;
        String secret = SECRET;
        params.put("appKey", appKey);
        Map<String,String> sign = Maps.newHashMap();
        sign.put("appKey", appKey);
        sign.put("secret", MakerSignUtil.generateSign(secret, params));
        return sign;
    }

    private void getUserInfo() {
        String url = makerHttpUrl + "/api/out/user";
        Map<String, Object> params = Maps.newHashMap();
        params.put("id",53356);
        params.put("menus", "BASIC,PROFILE");
        params.putAll(getSign(params));
        HttpRequest httpRequest = HttpRequest.get(url, params, true);
        System.out.println("requestUrl:{}" + httpRequest.toString());
        String returnJson = httpRequest.body();
        System.out.println("query stock ehaier return json:" + returnJson);

        if (httpRequest.code() !=200) {
            System.out.println("http status:"+httpRequest.code());
        }
    }

    private void findById() {
        String url = makerHttpUrl + "/api/out/user";
        Map<String, Object> params = Maps.newHashMap();
        params.put("id",23642);
        params.put("menus", "BASIC,PROFILE");
        params.putAll(getSign(params));
        HttpRequest httpRequest = HttpRequest.get(url, params, true);
        System.out.println("requestUrl:{}" + httpRequest.toString());
        String returnJson = httpRequest.body();
        System.out.println("query stock ehaier return json:" + returnJson);

        if (httpRequest.code() !=200) {
            System.out.println("http status:"+httpRequest.code());
        }
    }


    private void register() {
        String url = makerHttpUrl + "/api/out/user/register";
        Map<String, Object> params = Maps.newHashMap();
        params.put("email","zhangb@terminus.io");
        params.put("password", "123456");
        params.put("nickname", "toc_shop");
        params.put("mobile","");
        params.putAll(getSign(params));
        HttpRequest httpRequest = HttpRequest.post(url, true).form(params);
        System.out.println("requestUrl:{}" + httpRequest.toString());
        String returnJson = httpRequest.body();
        System.out.println("query stock ehaier return json:" + returnJson);

        if (httpRequest.code() !=200) {
            System.out.println("http status:"+httpRequest.code());
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {



    }

}
