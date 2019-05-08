package com.brcc.business.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringFactory
{
    /**
     * 判断字符串为空或者为null
     * 
     * @param strTemp
     *            字符串
     * @return 如果为空或null返回true，否则为false
     */
	public static boolean isNotNull(String strTemp)
	{
		if (strTemp == null || strTemp.trim().equals(""))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * */
	public static String formatIfNull(String strTemp)
	{
	    if (strTemp == null)
	    {
	        return "";
	    }
	    return strTemp;
	}

	/**
	 * 判断fileName是否合法，不区分大小写。 合法文件后缀为 "txt", "gif", "jpg", "jpeg", "jpe", "zip",
	 * "rar", "doc", "ppt", "xls", "html", "htm", "tif", "tiff", "pdf"
	 * 
	 * @param fileName
	 *            文件名后缀
	 * @return 符合返回true
	 */
	public static boolean isValidFile(String fileName)
	{
		String[] validFiles =
		{ "txt", "gif", "jpg", "jpeg", "jpe", "zip", "rar", "doc", "ppt",
				"xls", "csv", "html", "htm", "tif", "tiff", "pdf" };
		boolean ret = false;
		for (int i = 0; i < validFiles.length; i++)
		{
			if (fileName.toLowerCase().endsWith(validFiles[i]))
			{
				ret = true;
				break;
			}
		}
		return ret;
	}

	/**
	 * 根据具体的file得到它对应的ContentType
	 * 
	 * @param fileName
	 *            文件后缀名
	 * @return 对应的ContentType
	 */
	public static String getContentType(String fileName)
	{
		String fileNameTmp = fileName.toLowerCase();
		String ret = "";
		if (fileNameTmp.endsWith("txt"))
		{
			ret = "text/plain";
		}

		if (fileNameTmp.endsWith("gif"))
		{
			ret = "image/gif";
		}

		if (fileNameTmp.endsWith("jpg"))
		{
			ret = "image/jpeg";
		}

		if (fileNameTmp.endsWith("jpeg"))
		{
			ret = "image/jpeg";
		}

		if (fileNameTmp.endsWith("jpe"))
		{
			ret = "image/jpeg";
		}

		if (fileNameTmp.endsWith("zip"))
		{
			ret = "application/zip";
		}

		if (fileNameTmp.endsWith("rar"))
		{
			ret = "application/rar";
		}

		if (fileNameTmp.endsWith("doc"))
		{
			ret = "application/msword";
		}

		if (fileNameTmp.endsWith("ppt"))
		{
			ret = "application/vnd.ms-powerpoint";
		}

		if (fileNameTmp.endsWith("xls"))
		{
			ret = "application/vnd.ms-excel";
		}

		if (fileNameTmp.endsWith("csv"))
		{
			ret = "application/csv";
		}

		if (fileNameTmp.endsWith("html"))
		{
			ret = "text/html";
		}

		if (fileNameTmp.endsWith("htm"))
		{
			ret = "text/html";
		}

		if (fileNameTmp.endsWith("tif"))
		{
			ret = "image/tiff";
		}

		if (fileNameTmp.endsWith("tiff"))
		{
			ret = "image/tiff";
		}

		if (fileNameTmp.endsWith("pdf"))
		{
			ret = "application/pdf";
		}

		return ret;
	}
	
    /**
     * 把属性字符串分割为集合。
     * 例如 12679662676:工作日程#2989856879:私人日程，得到结果为两个记录的集合。
     * key是12679662676，内容是工作日程
     * key是2989856879，内容是私人日程
     * 
     * @param strContent
     *            属性字符串
     * @return 结果集合
     */
	public static Map<String, String> property2Map(String strContent)
	{
	    Map<String, String> mProperty = new HashMap<String, String>();
	    
	    if (StringFactory.isNotNull(strContent))
        {
            String[] arrTemp = strContent.split("#");
            for (int i=0; i<arrTemp.length; i++)
            {
                try
                {
                    String strKey   = arrTemp[i].substring(0, arrTemp[i].indexOf(":")).trim();
                    String strValue = arrTemp[i].substring(arrTemp[i].indexOf(":") + 1).trim();
                    mProperty.put(strKey, strValue);
                }
                catch(java.lang.StringIndexOutOfBoundsException oe)
                {
                    
                }
            }
        }
	    
	    return mProperty;
	}

    /**
     * 把属性字符串分割为集合。
     * 例如 文件名1.txt:12679662676.txt:工作日程#文件名2.doc:2989856879.doc:私人日程，得到结果为两个记录的集合。
     * key是12679662676.txt，内容是文件名1.txt
     * key是2989856879.doc，内容是文件名2.doc
     * 
     * @param strContent
     *            属性字符串
     * @return 结果集合
     */
    public static Map<String, String> property2MapFileName(String strContent)
    {
        Map<String, String> mProperty = new HashMap<String, String>();
        
        if (StringFactory.isNotNull(strContent))
        {
            String[] arrTemp = strContent.split("#");
            for (int i=0; i<arrTemp.length; i++)
            {
                try
                {
                    String[] arrSubTemp = arrTemp[i].split(":");
                    if (arrSubTemp.length==3)
                    {
                        String strKey   = arrSubTemp[1];
                        String strValue = arrSubTemp[0];
                        mProperty.put(strKey, strValue);
                    }
                }
                catch(java.lang.StringIndexOutOfBoundsException oe)
                {
                    
                }
            }
        }
        
        return mProperty;
    }

    /**
     * 把属性字符串分割为集合。
     * 例如 文件名1.txt:12679662676.txt:工作日程#文件名2.doc:2989856879.doc:私人日程，得到结果为两个记录的集合。
     * key是12679662676.txt，内容是工作日程
     * key是2989856879.doc，内容是私人日程
     * 
     * @param strContent
     *            属性字符串
     * @return 结果集合
     */
    public static Map<String, String> property2MapFileMemo(String strContent)
    {
        Map<String, String> mProperty = new HashMap<String, String>();
        
        if (StringFactory.isNotNull(strContent))
        {
            String[] arrTemp = strContent.split("#");
            for (int i=0; i<arrTemp.length; i++)
            {
                try
                {
                    String[] arrSubTemp = arrTemp[i].split(":");
                    if (arrSubTemp.length==3)
                    {
                        String strKey   = arrSubTemp[1];
                        String strValue = arrSubTemp[2];
                        mProperty.put(strKey, strValue);
                    }
                }
                catch(java.lang.StringIndexOutOfBoundsException oe)
                {
                    
                }
            }
        }
        
        return mProperty;
    }
    
    /**
     * 把属性字符串分割为集合。
     * 例如 230c3a27c0a8015001a17151d6c34b6d:电:万度/年#230c9ecdc0a8015000f6ac7f687ea815:油:吨/年#230c6b0bc0a80150007ed2630c7edd23:煤:吨/年#230bf927c0a80150003b889b0b76b9c6:蒸汽:吨/年#，得到结果为两个记录的集合。
     * key是12679662676.txt，内容是工作日程
     * key是2989856879.doc，内容是私人日程
     * 
     * @param strContent
     *            属性字符串
     * @return 结果集合
     */
    public static Map<String, String[]> property2AttributeMap(String strContent)
    {
        Map<String, String[]> mProperty = new HashMap<String, String[]>();
        
        if (StringFactory.isNotNull(strContent))
        {
            String[] arrTemp = StringFactory.string2Array(strContent);
            for (int i=0; i<arrTemp.length; i++)
            {
                String[] arrJ = arrTemp[i].split(":");
                mProperty.put(arrJ[1], arrJ);
            }
        }
        
        return mProperty;
    }
    
    /**
     * 把属性字符串分割为数组。
     * 例如 230c3a27c0a8015001a17151d6c34b6d:电:万度/年#230c9ecdc0a8015000f6ac7f687ea815:油:吨/年#230c6b0bc0a80150007ed2630c7edd23:煤:吨/年#230bf927c0a80150003b889b0b76b9c6:蒸汽:吨/年#，得到结果为两个记录的集合。
     * key是12679662676.txt，内容是工作日程
     * key是2989856879.doc，内容是私人日程
     * 
     * @param strContent
     *            属性字符串
     * @return 结果集合
     */
    public static String[] property2String(String strContent)
    {
        if (StringFactory.isNotNull(strContent))
        {
            String[] arrTemp = strContent.split("#");
            String[] arrResult = new String[arrTemp.length];
            for (int i=0; i<arrTemp.length; i++)
            {
                try
                {
                    String[] arrSubTemp = arrTemp[i].split(":");
                    if (arrSubTemp.length==3)
                    {
                        String strValue = arrSubTemp[2];
                        arrResult[i] = strValue;
                    }
                }
                catch(java.lang.StringIndexOutOfBoundsException oe)
                {
                    
                }
            }
            return arrResult;
        }
        
        return new String[0];
    }
    
    /**
     * 把属性字符串分割为数组。
     * 忽略Key值<p>
     * 例如 12679662676:工作日程#2989856879:私人日程，得到结果为两个记录的集合。
     * 内容是工作日程
     * 内容是私人日程
     * 
     * @param strContent
     *            属性字符串
     * @return 结果数组
     */
    public static String[] property2Array(String strContent)
    {
        try
        {
            if (StringFactory.isNotNull(strContent))
            {
                String[] arrTemp = strContent.split("#");
                String[] arrResult = new String[arrTemp.length];
                
                Set<String> set = new TreeSet<String>();
                for (int i=0; i<arrTemp.length; i++)
                {
                    try
                    {
                        set.add(arrTemp[i].substring(arrTemp[i].indexOf(":") + 1).trim());
                    }
                    catch(java.lang.StringIndexOutOfBoundsException oe)
                    {
                        
                    }
                }

                Iterator<String> iterator = set.iterator();
                int i = 0;
                while(iterator.hasNext())
                {
                    arrResult[i] = iterator.next().toString();
                    i ++;
                }
                
                return arrResult;
            }            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();            
        }

        return new String[0];
    }	

    public static String[] property2Array(String strContent, String validateValue, int index, int compareIndex)
    {
        if (StringFactory.isNotNull(strContent))
        {
            String[] arrTemp = strContent.split("#");
            Collection<String> results = new ArrayList<String>();
            
            for (int i=0, j=0; i<arrTemp.length; i++)
            {
                try
                {
                    String[] arrSubTemp = arrTemp[i].split(":");
                    
                    if (!StringFactory.isNotNull(validateValue))
                    {
                        results.add(arrSubTemp[index]);
                        j++;
                    }
                    else if (StringFactory.isNotNull(arrSubTemp[index]) && validateValue.equals(arrSubTemp[compareIndex]))
                    {
                        results.add(arrSubTemp[index]);
                        j++;
                    }
                }
                catch(java.lang.StringIndexOutOfBoundsException oe)
                {
                    
                }
                
            }
            return  (String[])results.toArray(new String[results.size()]);
        }
        return new String[0];
    }
    
    /**
     * 把属性字符串分割为数组。
     * 忽略value值<p>
     * 例如 12679662676:工作日程#2989856879:私人日程，byValue=私人日程，得到结果为1个记录的集合。
     * 内容是2989856879
     * 
     * @param strContent
     *            属性字符串
     *        byValue
     *            需要匹配的字符串值
     * @return 结果数组
     */
    public static String[] propertySplitKeyByValue2Array(String strContent, String byValue)
    {
        try
        {
            if (StringFactory.isNotNull(strContent))
            {
                String[] arrTemp = strContent.split("#");
                Collection<String> results = new ArrayList<String>();
                
                for (int i=0, j=0; i<arrTemp.length; i++)
                {
                    try
                    {
                        int index = arrTemp[i].indexOf(":");
                        String strKey   = arrTemp[i].substring(0, index).trim();
                        String strValue = arrTemp[i].substring(index + 1).trim();
                        if (strValue.equals(byValue))
                        {
                            results.add(strKey);
                            j++;
                        }
                    }
                    catch(java.lang.StringIndexOutOfBoundsException oe)
                    {
                        
                    }
                    
                }
                return  (String[])results.toArray(new String[results.size()]);
            }            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return new String[0];
    }
    
    /**
     * 把key值数组组合为#分割的字符串。
     * 例如 {'a', 'b'}，得到结果为'a#b'。
     * 
     * @param arrKey
     *            key值数组
     * @return 结果字符串
     */
    public static String array2String(String[] arrKey)
    {
        try
        {
            if (arrKey==null)
            {
                return "";
            }
            
            String strTemp = "";
            for (int i=0; i<arrKey.length; i++)
            {
                strTemp += arrKey[i];
                if ((i+1)!=arrKey.length)
                {
                    strTemp += "#";
                }
            }
            return strTemp;
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return "";
    }   
    
    /**
     * 把#分割的字符串合转化为key值数组。
     * 例如'a#b'，得到结果为 {'a', 'b'}。
     * 
     * @param strTemp
     *            #分割的字符串
     * @return 结果字符串
     */
    public static String[] string2Array(String strTemp)
    {
        if (strTemp == null)
        {
            String[] arrStr = {""};
            return arrStr;
        }
        return strTemp.split("#");
    }     
    
    /**
     * 把分割的字符串合转化为key值数组。
     * 例如'a:b'，得到结果为 {'a', 'b'}。
     * 
     * @param strTemp
     * @param regex 分割的字符串
     * @return 结果字符串数组
     */
    public static String[] string2ArrayByRegex(String strTemp, String regex)
    {
        String[] arrStr = {"", ""};
        
        if (StringFactory.isNotNull(strTemp) && strTemp.indexOf(":") > 0)
        {
            arrStr = strTemp.split(":");
        }
        return arrStr;
    }   
    
    /**
     * 转换字符串的编码
     *
     * @param   strTemp 需要转换的字符串
     *          sourceCode 原编码号
     *          toCode     转换后的编码号
     * @return 转换编码的字符串
     */
     public static String convertStringEncoding(String strTemp, String sourceCode, String toCode)
     {
         try
         {
             if (isNotNull(strTemp))
             {
                 strTemp =  new String(strTemp.getBytes(sourceCode), toCode);
             }
         }
         catch (java.io.UnsupportedEncodingException ex)
         {
             System.out.println("UtilFactory Error: unsupported encoding("+ sourceCode +" to "+ toCode +")");
         }

         return strTemp;
     }
     
     /**
      * 格式化指定长度的字符串，前补零
      * @param strTemp 需要格式化长度的字符串
      * @param length 指定长度
      * 
      * @return 字符串
      * */
     public static String fullZeroLength(String strTemp, int length)
     {
         String strResult = strTemp;
         for(int i=0; i<length - strTemp.length(); i++)
         {
             strResult = "0" + strResult;
         }
         return strResult;
     }
     
     /**
     * 半角 DBC case -> 全角 SBC case
     * @param QJstr String
     * @return String
     */
    public static final String BQchange(String QJstr)
    {
        String outStr = "";
        try
        {
            for (int i = 0; i < QJstr.length(); i++)
            {
                String strTmp = QJstr.substring(i, i + 1);
                byte[] b = strTmp.getBytes("unicode");
                if (b[3] == 0)
                {
                    b[2] = (byte) (b[2] - 32);
                    b[3] = -1;
                    outStr = outStr + new String(b, "unicode");
                }
                else
                {
                    outStr = outStr + strTmp;
                }
            }
        }
        catch (java.io.UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return outStr;
    }

    /**
     * 全角 转换成 -> 半角(*)
     * @param QJstr String
     * @return String
     */
    public static final String QBchange(String QJstr)
    {
        String outStr = "";
        try
        {
            String Tstr = "";
            byte[] b = null;

            for (int i = 0; i < QJstr.length(); i++)
            {
                Tstr = QJstr.substring(i, i + 1);
                b = Tstr.getBytes("unicode");
                if (b[3] == -1)
                {
                    b[2] = (byte) (b[2] + 32);
                    b[3] = 0;
                    outStr = outStr + new String(b, "unicode");
                }
                else
                {
                    outStr = outStr + Tstr;
                }
            }
        }
        catch (java.io.UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return outStr;
    }

    public static String substringByCase(String src, int intBegin)
    {
        return substringByCase(src, intBegin, src.getBytes().length + 1);
    }

    // 汉字长度为2，半角数字为1
    public static String substringByCase(String str, int intBegin, int intEnd)
    {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int len = 0;
        while (i < str.length())
        {
            char c = str.charAt(i);

            if (len >= intBegin && len < intEnd)
            {
                sb.append(c);
            }

            if (c < 128) // 半角
            {
                len++;
            }
            else        // 全角
            {
                len += 2;
            }
            i++;
        }
        return sb.toString();
    }

    // 汉字长度为2，半角数字为1
    public static String fillBlankChar(String strChar, int intLength)
    {
        if (strChar == null)
        {
            strChar = "";
        }
        
        int i = 0;
        int len = 0;
        String strTemp = "";
        boolean flag = false;
        while (i < strChar.length())
        {
            char c = strChar.charAt(i);
            if (len == (intLength - 1))
            {
                flag = true;
            }

            if (c < 128) //半角
            {
                len++;

                if (flag)
                {
                    strTemp += c;
                    return strTemp;
                }
            }
            else  //全角
            {
                len += 2;

                if (flag)
                {
                    return strTemp + " ";
                }
            }
            strTemp += c;
            i++;
        }

        return strChar + fillLeft2Length(" ", intLength - len); //左补空格
    }
    
    //左补单个字符填充到某个长度.
    public static String fillLeft2Length(String strChar, int intLength)
    {
        String strResult = "";
        for (int m=0; m<intLength; m++)
        {
            strResult += strChar;
        }
        return strResult;
    }
    
    /*
    对输入的数字进行格式化，必须符合XXXXX.XX的格式。
    包括123456.00
    */
    public static String formatRmb(String strRbm)
    {
        String strDianfei_zhen = "", strDianfei_xiao = "", strResult = "";
    
        //把money分为“.”之前和之后
        int intDotIndex = strRbm.indexOf(".");
        if (intDotIndex != -1)
        {
            strDianfei_zhen = strRbm.substring(0, intDotIndex);
            strDianfei_xiao = strRbm.substring(intDotIndex + 1);
    
            if (strDianfei_xiao.length() > 2)
            {
                strDianfei_xiao = strDianfei_xiao.substring(0, 2);
            }
    
            for (int i=strDianfei_xiao.length(); i<2; i++)
            {
                strDianfei_xiao += "0";
            }
            strResult = strDianfei_zhen + "." + strDianfei_xiao;
        }
        else
        {
            strResult = strRbm + ".00";
        }
        return strResult;
    }
    
    //转化费用为字符串，不足位数采取高位补0
    public static String formatByLength(double dblDianfei, int intLength)
    {
        String strDianfei = formatRmb(Double.toString(dblDianfei));
    
        // 去掉字符串中有小数点
        String strTemp1 = "", strTemp2 = "";
        strTemp1 = strDianfei.substring(0, strDianfei.indexOf("."));
        strTemp2 = strDianfei.substring(strDianfei.indexOf(".") + 1);
        if (strTemp2.length() < 2)
        {
            for (int i=0; i<strTemp2.length(); i++)
            {
                strTemp2 += "0";
            }
        }
        else if (strTemp2.length() > 2)
        {
            strTemp2 = strTemp2.substring(0, 2);;
        }
        strDianfei = strTemp1 + strTemp2;
    
    
        int intDfLength = strDianfei.length();
        if (intDfLength < intLength)
        {
            for (int m=0; m<(intLength - intDfLength); m++)
            {
                strDianfei = "0" + strDianfei;//不足则高位补0
            }
        }
        return strDianfei;
    }
    
    //转化费用为字符串，不足位数采取高位补0
    public static String formatByLengthRight(double dblDianfei, int intLength, String strChar)
    {
        String strDianfei = formatRmb(Double.toString(dblDianfei));
    
        // 去掉字符串中有小数点
        String strTemp1 = "", strTemp2 = "";
        strTemp1 = strDianfei.substring(0, strDianfei.indexOf("."));
        strTemp2 = strDianfei.substring(strDianfei.indexOf(".") + 1);
        if (strTemp2.length() < 2)
        {
            for (int i=0; i<strTemp2.length(); i++)
            {
                strTemp2 += "0";
            }
        }
        else if (strTemp2.length() > 2)
        {
            strTemp2 = strTemp2.substring(0, 2);;
        }
        strDianfei = strTemp1 + strTemp2;
    
    
        int intDfLength = strDianfei.length();
        if (intDfLength < intLength)
        {
            for (int m=0; m<(intLength - intDfLength); m++)
            {
                strDianfei =  strDianfei + strChar;//不足则低位补空格
            }
        }
        return strDianfei;
    }
    
    //转化账单笔数为字符串，不足位数采取高位补0
    public static String formatByLength(int intNum, int intLength)
    {
        String strNum = Integer.toString(intNum);
        int intDfLength = strNum.length();
        if (intDfLength < intLength)
        {
            for (int m=0; m<(intLength - intDfLength); m++)
            {
                strNum = "0" + strNum;//不足则高位补0
            }
        }
        return strNum;
    }
    
    //右（低位）补充字符串到符合长度
    public static String formatByLength_RightFill(String strChar, int intLength, String strFillChar)
    {
        int intDfLength = strChar.length();
        if (intDfLength < intLength)
        {
            for (int m=0; m<(intLength - intDfLength); m++)
            {
                strChar += strFillChar;//不足则低位补
            }
        }
        return strChar;
    }
    
    //左（高位）补充字符串到符合长度
    public static String formatByLength_LeftFill(String strChar, int intLength, String strFillChar)
    {
        int intDfLength = strChar.length();
        if (intDfLength < intLength)
        {
            for (int m=0; m<(intLength - intDfLength); m++)
            {
                strChar = strFillChar + strChar;//不足则高位补
            }
        }
        return strChar;
    }

    public static String md5s(String plainText) throws NoSuchAlgorithmException 
    {
    	MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(plainText.getBytes());
		byte b[] = md.digest();
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) 
		{
		    i = b[offset];
		    if (i < 0)
		    	i += 256;
		    if (i < 16)
		    	buf.append("0");
		    buf.append(Integer.toHexString(i));
		}
		String str = buf.toString();
	//	System.out.println("result: " + buf.toString());// 32位的加密
	//	System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
		return str;
    }
    public static String parseZsBankOrder(HashMap map)
    {
    	String orderInfo = "";
    	Iterator<String> iter = map.keySet().iterator();
    	while (iter.hasNext()) {
    		String key = iter.next();
    		
    		String value = (String)map.get(key);
    	    if(isNotNull(value))
    	    {
    	    	String valueStr = value + " ;";
    	    	orderInfo = orderInfo + key + "=" + valueStr;
    	    }
    	}
    	
    	return orderInfo.substring(0,orderInfo.length()-2);
    }

    //网银以及线下支付涉及的手续费收取
    public static double gainPayCharge(){
    	double charge = 0.003;
    	try {
    		Date curDate = Calendar.getInstance().getTime();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date furDate = sdf.parse("2018-02-01");
			if(curDate.compareTo(furDate) > 0)
				charge = 0.003;
		} catch (ParseException e) {
			
		}
    	return charge;
    }
  
    //网银以及线下支付涉及的手续费收取（最低限额，目前是1000）
    public static double gainMiniLimit(){
    	double miniLimit = 1000;
    	
    	return miniLimit;
    }
    
    public static double getTaxRate() {
    	return 0.10;
    }
};