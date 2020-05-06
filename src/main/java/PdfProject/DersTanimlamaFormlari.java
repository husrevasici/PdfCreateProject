package PdfProject;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DersTanimlamaFormlari {
	public String word[] = { "[Dd][Ee][Rr][Ss][İi][Nn]\\s*[Kk][Oo][Dd][Uu]\\s*[Vv][Ee]\\s*[Aa][Dd][Iı].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s*[Yy][Aa][Rr][Iı][Yy][Iı][Ll][Iı].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s*[İi][Çç][Ee][Rr][İi][Ğğ][İi].*",
			"[Dd][Ee][Rr][Ss]\\s*[Kk][İi][Tt][Aa][Bb][Iı].*",
			"[Yy][Aa][Rr][Dd][Iı][Mm][Cc][Iı]\\s*[Dd][Ee][Rr][Ss]\\s*[Kk][İi][Tt][Aa][Pp][Ll][Aa][Rr][Iı].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s*[Kk][Rr][Ee][Dd][İi][Ss][İi].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s*[Öö][Nn][Kk][Oo][Şş][Uu][Ll][Ll][Aa][Rr][Iı].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s*[Tt][Üü][Rr][Üü].*", "[Öö][Ğğ][Rr][Ee][Tt][İi][Mm]\\s*[Dd][İi][Ll][İi].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s[Aa][Mm][Aa][Çç][Ll][Aa][Rr][Iı].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s[Öö][Ğğ][Rr][Ee][Nn][İi][Mm]\\s[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s[Vv][Ee][Rr][İi][Ll][İi][Şş]\\s[Bb][İi][Çç][İi][Mm][İi].*",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s[Hh][Aa][Ff][Tt][Aa][Ll][Iı][Kk]\\s[Dd][Aa][Ğğ][Iı][Ll][Iı][Mm][Iı].*",
			"[Ee][Ğğ][İi][Tt][İi][Mm]\\s[Vv][Ee]\\s[Öö][Ğğ][Rr][Ee][Tt][İi][Mm]\\s[Ff][Aa][Aa][Ll][İi][Yy][Ee][Tt][Ll][Ee][Rr][İi].*",
			"[Dd][Ee][Ğğ][Ee][Rr][Ll][Ee][Nn][Dd][İi][Rr][Mm][Ee]\\s[Öö][Ll][Çç][Üü][Tt][Ll][Ee][Rr][İi]",
			"[Dd][Ee][Rr][Ss][İi][Nn]\\s[İi][Şş]\\s[Yy][Üü][Kk][Üü]",
			"[Dd][Ee][Rr][Ss]\\s[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı]\\s[İi][Ll][Ee]\\s[Pp][Rr][Oo][Gg][Rr][Aa][Mm]\\s"
					+ "[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı]\\s[Aa][Rr][Aa][Ss][Iı][Nn][Dd][Aa][Kk][İi]",
			"[Dd][Ee][Rr][Ss][İi]\\s*+[Vv][eE][Rr][Ee][Cc][Ee][Kk]\\s*+[Öö][Ğğ][Rr][Ee][Tt][İi][Mm]\\s*+[Ee][Ll][Ee][Mm][Aa][Nn][(][Ll][Aa][Rr][)][Iı]\\s*+[Vv][Ee]\\s*+[İi][Ll][Ee][Tt][İi][Şş][İi][Mm]" };

	public String word2[] = { "([Dd][Ee][Rr][Ss][İi][Nn]\\s*[Kk][Oo][Dd][Uu]\\s*[Vv][Ee]\\s*[Aa][Dd][Iı])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s*[Yy][Aa][Rr][Iı][Yy][Iı][Ll][Iı])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s*[İi][Çç][Ee][Rr][İi][Ğğ][İi])(.+?)",
			"([Dd][Ee][Rr][Ss]\\s*[Kk][İi][Tt][Aa][Bb][Iı])(.+?)",
			"([Yy][Aa][Rr][Dd][Iı][Mm][Cc][Iı]\\s*[Dd][Ee][Rr][Ss]\\s*[Kk][İi][Tt][Aa][Pp][Ll][Aa][Rr][Iı])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s*[Kk][Rr][Ee][Dd][İi][Ss][İi])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s*[Öö][Nn][Kk][Oo][Şş][Uu][Ll][Ll][Aa][Rr][Iı])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s*[Tt][Üü][Rr][Üü])(.+?)",
			"([Öö][Ğğ][Rr][Ee][Tt][İi][Mm]\\s*[Dd][İi][Ll][İi])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s[Aa][Mm][Aa][Çç][Ll][Aa][Rr][Iı])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s[Öö][Ğğ][Rr][Ee][Nn][İi][Mm]\\s[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s[Vv][Ee][Rr][İi][Ll][İi][Şş]\\s[Bb][İi][Çç][İi][Mm][İi])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s[Hh][Aa][Ff][Tt][Aa][Ll][Iı][Kk]\\s[Dd][Aa][Ğğ][Iı][Ll][Iı][Mm][Iı])(.+?)",
			"([Ee][Ğğ][İi][Tt][İi][Mm]\\s[Vv][Ee]\\s[Öö][Ğğ][Rr][Ee][Tt][İi][Mm]\\s[Ff][Aa][Aa][Ll][İi][Yy][Ee][Tt][Ll][Ee][Rr][İi])(.+?)",
			"([Dd][Ee][Ğğ][Ee][Rr][Ll][Ee][Nn][Dd][İi][Rr][Mm][Ee]\\s[Öö][Ll][Çç][Üü][Tt][Ll][Ee][Rr][İi])(.+?)",
			"([Dd][Ee][Rr][Ss][İi][Nn]\\s[İi][Şş]\\s[Yy][Üü][Kk][Üü])(.+?)",
			"([Dd][Ee][Rr][Ss]\\s[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı]\\s[İi][Ll][Ee]\\s[Pp][Rr][Oo][Gg][Rr][Aa][Mm]\\s"
					+ "[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı]\\s[Aa][Rr][Aa][Ss][Iı][Nn][Dd][Aa][Kk][İi])(.+?)" };
	public String degerlendirmeOlcutleri[] = {
			"\\b([Aa][Rr][Aa]\\s*+[Ss][Iı][Nn][Aa][Vv]\\s*+)(\\d{0,2}\\s*+)(\\d{0,3})\\b",
			"\\b([Öö][Dd][Ee][Vv]\\s*+)(\\d{0,3}\\s*+)(\\d{0,3})\\b",
			"\\b([Uu][Yy][Gg][Uu][Ll][Aa][Mm][Aa]\\s*+)(\\d{0,3}\\s*+)(\\d{0,3})\\b",
			"\\b([Pp][Rr][Oo][Jj][Ee][Ll][Ee][Rr]\\s*+)(\\d{0,3}\\s*+)(\\d{0,3})\\b",
			"\\b([Pp][Rr][Aa][Tt][İi][Kk]\\s*+)(\\d{0,3}\\s*+)(\\d{0,3})\\b",
			"\\b([Kk][Iı][Ss][Aa]\\s*+[Ss][Iı][Nn][Aa][Vv]\\s*+)(\\d{0,3}\\s*+)(\\d{0,3})\\b",

			"\\b([Dd][Öö][Nn][Ee][Mm][İi][Çç][İi]\\s*+[Çç][Aa][Ll][Iı][Şş][Mm][Aa][Ll][Aa][Rr][Iı][Nn]\\s*+[Yy][Iı][Ll]\\s*+"
					+ "[İi][Çç][İi]\\s*+[Bb][Aa][Şş][Aa][Rr][Iı][Yy][Aa]\\s*+[Oo][Rr][Aa][Nn][Iı]\\s*+)([(][%][)])\\s*+(\\d{0,2}\\s*+\\d{0,3})\\b",

			"\\b([Ff][İi][Nn][Aa][Ll][İi][Nn]\\s*+[Bb][Aa][Şş][Aa][Rr][Iı][Yy][Aa]\\s*+[Oo][Rr][Aa][Nn][Iı])\\s*+"
					+ "([(][%][)])\\s*+(\\d{0,2}\\s*+\\d{0,3})\\b",
			"\\b([Dd][Ee][Vv][Aa][Mm]\\s*+[Dd][Uu][Rr][Uu][Mm][Uu])\\s*+(\\d{0,3})\\s*+(\\d{0,3})\\b" };
	public String DersinIsYuku[] = {
			"\\b([Hh][Aa][Ff][Tt][Aa][Ll][Iı][Kk]\\s*+[Tt][Ee][Oo][Rr][İi][Kk]\\s*+[Dd][Ee][Rr][Ss]\\s*+[Ss][Aa][Aa][Tt][İi])\\s*+"
					+ "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Hh][Aa][Ff][Tt][Aa][Ll][Iı][Kk]\\s*+[Uu][Yy][Gg][Uu][Ll][Aa][Mm][Aa][Ll][Iı]\\s*+"
					+ "[Dd][Ee][Rr][Ss]\\s*+[Ss][Aa][Aa][Tt][İi])\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Oo][Kk][Uu][Mm][Aa]\\s*+[Ff][Aa][Aa][Ll][İi][Yy][Ee][Tt][Ll][Ee][Rr][İi])\\s*+"
					+ "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([İi][Nn][Tt][Ee][Rr][Nn][Ee][Tt][Tt][Ee][Nn]\\s*+[Tt][Aa][Rr][Aa][Mm][Aa][,]\\s*+[Kk][Üü][Tt][Üü][Pp][Hh][Aa][Nn][Ee]\\s*+"
					+ "[Çç][Aa][Ll][Iı][Şş][Mm][Aa][Ss][Iı])\\s*+" + "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Mm][Aa][Tt][Ee][Rr][Yy][Aa][Ll]\\s*+[Tt][Aa][Ss][Aa][Rr][Ll][Aa][Mm][Aa][,]\\s*+[Uu][Yy][Gg][Uu][Ll][Aa][Mm][Aa])\\s*+"
					+ "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Rr][Aa][Pp][Oo][Rr]\\s*+[Hh][Aa][Zz][Iı][Rr][Ll][Aa][Mm][Aa])\\s*+"
					+ "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Ss][Uu][Nn][Uu]\\s*+[Hh][Aa][Zz][Iı][Rr][Ll][Aa][Mm][Aa])\\s*+"
					+ "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Ss][Uu][Nn][Uu][Mm])\\s*+" + "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Aa][Rr][Aa]\\s*+[Ss][Iı][Nn][Aa][Vv]\\s*+[Vv][Ee]\\s*+[Aa][Rr][Aa]\\s*+[Ss][Iı][Nn][Aa][Vv][Aa]\\s*+[Hh][Aa][Zz][Iı][Rr][Ll][Iı][Kk])\\s*+"
					+ "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Ff][İi][Nn][Aa][Ll]\\s*+[Ss][Iı][Nn][Aa][Vv][Iı]\\s*+[Vv][Ee]\\s*+[Ff][İi][Nn][Aa][Ll]\\s*+[Ss][Iı][Nn][Aa][Vv][Iı][Nn][Aa]\\s*+[Hh][Aa][Zz][Iı][Rr][Ll][Iı][Kk])\\s*+"
					+ "(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Dd][İi][Ğğ][Ee][Rr])\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\s*+(\\d{0,2})\\b",
			"\\b([Tt][Oo][Pp][Ll][Aa][Mm]\\s*+[İi][Şş]\\s*+[Yy][Üü][Kk][Üü])\\s*+"
					+ "(\\d{1,3})\\s*+(\\d{0,3})\\s*+(\\d{0,3})\\b",
			"\\b([Tt][Oo][Pp][Ll][Aa][Mm]\\s*+[İi][Şş]\\s*+[Yy][Üü][Kk][Üü]\\s*+[/]\\s*+\\d{0,2})\\s*+"
					+ "(\\d{0,3}.\\d{0,3}+)\\s*+(\\d{0,3})\\s*+(\\d{0,3})\\b",
			"\\b([Dd][Ee][Rr][Ss][İi][Nn]\\s*+[Aa][Kk][Tt][Ss]\\s*+[Kk][Rr][Ee][Dd][İi][Ss][İi])\\s*+"
					+ "(\\d{0,3})\\s*+(\\d{0,3})\\s*+(\\d{0,3})\\b" };
	public static Pattern p;
	public static Matcher m;
	static Hashtable<String, String> h = new Hashtable<String, String>();

} // end class
// "[Dd][Ee][Rr][Ss]\\s*+[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı]\\s*+[İi][Ll][Ee]\\s*+[Pp][Rr][Oo][Gg][Rr][Aa][Mm]\\s*+"
//+ "[Çç][ıI][Kk][Tt][Iı][Ll][Aa][Rr][Iı]\\s*+[Aa][Rr][Aa][Ss][Iı][Nn][Dd][Aa][Kk][İi]",
