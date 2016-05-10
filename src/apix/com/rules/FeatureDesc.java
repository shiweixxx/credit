/* sw
 * 2016-2016年4月29日-上午11:55:50
 * credit
 */
package apix.com.rules;

/**
 * @author sw
 *
 */
public class FeatureDesc {
/*    <th width="10%">特征</th>
    <th width="30%">策略集合</th>
    <th width="20%">是否满足</th>
    <th width="25%">该项得分</th>
    <th width="10%">判断标准</th>
    <th widht="5%">数据来源</th>*/
    private String featureName;
    private String featureList;
    private String isOk;
    private String score;
    private String JudegLevel;
    private String source;
    
	
	 
	
	/**
	 * @param featureList
	 * @param isOk
	 * @param score
	 * @param judegLevel
	 * @param source
	 */
	public FeatureDesc(String featureList, String isOk, String score, String judegLevel, String source) {
		super();
		this.featureList = featureList;
		this.isOk = isOk;
		this.score = score;
		JudegLevel = judegLevel;
		this.source = source;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getFeatureList() {
		return featureList;
	}
	public void setFeatureList(String featureList) {
		this.featureList = featureList;
	}
	public String getIsOk() {
		return isOk;
	}
	public void setIsOk(String isOk) {
		this.isOk = isOk;
	}
	public String getJudegLevel() {
		return JudegLevel;
	}
	public void setJudegLevel(String judegLevel) {
		JudegLevel = judegLevel;
	}
 
	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
    
}
