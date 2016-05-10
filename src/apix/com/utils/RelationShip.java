/* sw
 * 2016-2016年5月2日-下午6:57:58
 * credit
 */
package apix.com.utils;

import java.util.Arrays;

/**
 * @author sw
 *
 */
public class RelationShip {
	/*母亲*/
	private static final String[] mlist=new String[]{
			"妈","妈妈","麻麻","老妈","妈咪","妈眯","妈米","阿妈","娘","老娘",
			"阿娘","额娘"	,"皇额娘","母后","姆後","皇母娘娘","王母娘娘",
			"太后","皇太后","老佛爷","母亲","母","老母","老太太","妈妈咪","妈咪咪",
			"妈妈咪吖","妈妈咪呀","MA","AMA","MAMA","MOTHER","AMOTHER","MATHER",
			"MOM","MUM","MOMMY","MUMMY","MAMI","LAOMA",
			"继母","后妈","婆婆","他妈","他妈妈","岳母","丈母娘","她妈","她妈妈"
		};
	private static final String[] flist=new String[]{			
			"爸","爸爸","粑粑","巴巴","八八","老爸","爸比","爹滴","爹地","阿爸",
			"爹","阿爹","爹爹","老爹","阿玛","皇阿玛","父王","父皇","老豆","佬豆",
			"老头","老头子","老爷子","老汗","老汉","老子","老太爷","父亲","父","BA",
			"ABA","BABA","FATHER","AFATHER","DAD","DADDY","DAIDI","PAPA","lAOTOU",
			"LAOBA","继父","后爸","公公","他爸","他爸爸","岳父","岳丈","老丈人",
			"她爸","她爸爸"
		};
	private static final String[] hlist=new String[]{
			"家","家里","FAMILY","HOME","爸爸妈妈","爸妈","父母"};

	private static final String[] loverlist=new String[]{
			"老婆","佬嘙","老婆仔","老公","媳妇","媳妇儿","小媳妇","妻","妻子",
			"夫","丈夫","爱人","夫人","娘子","内人","娘们","老娘们","太太","良人",
			"婆娘","妇人","大少奶奶","太子妃","妃","妞","妞儿","小妞","小情人","情妹妹",
			"皇后","祖宗","亲爱","我最亲爱","亲爱滴","亲爱德","520","么么哒","宝宝","宝贝",
			"大宝贝","宝贝儿","乖乖","小乖乖","BABY","达令","DARLING","LOVE","LOVER","LOVEYOU",
			"MYLOVE","养我","小情绪","小笨蛋","唯一","最高指示","我家领导","女王陛下","你说了算","여보"}	;
	private static final String[] relist=new String[]{
			"爷","爷爷","奶奶","祖父","奶","祖母","外公","姥","姥姥","外婆","老老","姥爷",
			"叔","N叔","老叔","叔叔","伯伯","N伯伯","N伯","N爹","N爷","N爸爹",
			"姑","N姑","老姑","姑姑","N姑姑","姑妈","N姑妈","舅","N舅","老舅","舅舅","N舅舅",
			"姨","N姨","老姨","姨妈","N姨妈","哥哥","哥","N哥","老哥","弟弟","弟","N弟","老弟",
			"姐姐","姐","N姐","老姐","家姐","N家姐","妹妹","妹","N妹","老妹",
			"表哥","N表哥","堂哥","N堂哥","N叔子","N伯子","老公哥哥","老公弟弟",
			"表弟","N表弟","堂弟","N堂弟","N舅子","老婆哥哥","老婆弟弟",
			"表姐","N表姐","堂姐","N堂姐","N姑子","N姑姐","妯娌","老公姐姐","老公妹妹",
			"表妹","N表妹","堂妹","N堂妹","N姨子","老婆姐姐","老婆妹妹",
			"老婆","佬嘙","老婆仔","老公","媳妇","媳妇儿","小媳妇","妻","妻子",
			"夫","丈夫","爱人","夫人","娘子","内人","娘们","老娘们","太太","良人",
			"婆娘","妇人","大少奶奶","太子妃","妃","妞","妞儿","小妞","小情人","情妹妹",
			"皇后","祖宗","亲爱","我最亲爱","亲爱滴","亲爱德","520","么么哒","宝宝","宝贝",
			"大宝贝","宝贝儿","乖乖","小乖乖","BABY","达令","DARLING","LOVE","LOVER","LOVEYOU",
			"MYLOVE","养我","小情绪","小笨蛋","唯一","最高指示","我家领导","女王陛下","你说了算","여보"
			};
	
	/*commonfunction*/
	public boolean relationship(String[] rlist,String uname){
		String sb=new StringBuffer(uname.replaceAll("\\s+",""))
				.toString().toUpperCase();
		for(String str:rlist){
			//模糊匹配
			if (sb.startsWith(str))
				return true;
		}
		return false;		
	}
	/*父亲*/
	public boolean isFather(String uname){
		return this.relationship(flist, uname);
	}
	/*母亲*/
	public boolean isMather(String uname){
		return this.relationship(mlist, uname);
	}
	/*家*/
	public boolean isHome(String uname){
		return this.relationship(hlist, uname);
	}
	/*配偶*/
	public boolean isLover(String uname){
		return this.relationship(loverlist, uname);
	}
	/*是否亲属*/	
	public boolean isRelative(String uname){
		String[] prex_list=new String[]{
				"大","二","三","四","五","六","七","八",
				"九","小","幺","1","2","3","4","5","6","7","8","9"	
		};
		StringBuffer sb=new StringBuffer(uname);
		for(String str:prex_list){
			if(uname.startsWith(str)){
				sb=new StringBuffer(uname.replaceFirst(str,"N"));
			}
		}
		return this.relationship(relist, sb.toString());
	}
	 public static void main(String[] args) {
//		 System.out.println(new RelationShip().isRelative(""));
	}
}
