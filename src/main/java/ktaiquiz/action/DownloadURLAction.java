package ktaiquiz.action;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

import ktaiquiz.dto.ConditionDto;

import org.apache.commons.codec.digest.DigestUtils;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;


public class DownloadURLAction {

	public static final String URL = "http://localhost/ktaiquiz/";

	@Execute(validator = false)
	public String index() throws UnsupportedEncodingException {

		DecimalFormat df = new DecimalFormat("0000");

		StringBuilder sb = new StringBuilder();

		sb.append(URL);
		sb.append("admin");
		sb.append("/");
		sb.append(DigestUtils.md5Hex("admin" + ConditionDto.SALT).substring(0, 4));
		sb.append("\r\n");

		for (int i = 1 ; i <= 256 ; i++) {
			String s = df.format(i);
			sb.append(URL);
			sb.append(s);
			sb.append("/");
			sb.append(DigestUtils.md5Hex(s + ConditionDto.SALT).substring(0, 4));
			sb.append("\r\n");
		}

		ResponseUtil.download(new String("URL.txt"), sb.toString().getBytes("Shift_JIS"));
		return null;
	}
}
