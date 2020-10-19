## 常用数据类型
1. 字符串数据类型

- CHAR/CHARACTER
	
> 语法： CHAR[长度]/CHARACTER[长度] &ensp; &ensp;(默认长度1)
	
- VARCHAR/VARCHAR2
	> 语法：VARCHAR[长度]/VARCHAR2[长度] &ensp; &ensp;(默认长度8188)

	|数据库页面大小|最大长度|
	|:-----:|:-----:|
	|4K|1900|
	|8K|3900|
	|16K|8000|
	|32K|8188|

2. 数值数据类型

- 精确数值数据类型
	- NUMERIC/DECIMAL/DEC/NUMBER
		> 语法：NUMERIC[精度,标度]

		> 精度：总的数字数 &ensp; 标度：小数位数 &ensp; 标度<精度

		> 其值超过精度，DM会返回一个出错信息，如果超过标度，则多余的位会被截断。

	- INTEGER/INT/BIGINT/TINYINT/BYTE/SMALLINT
		> 语法：INTEGER &ensp; &ensp; 用于存储有符号整数，标度均为0

		> 精度分别为10/10/19/3/3/5

	- BINARY/VARBINARY
		> 语法：BINARY[长度]

		>存储定长二进制，默认长度、最大长度算法参考VARVHAR与CHAR，数据以十六进制表示

- 近似数值数据类型
	- FLOAT/DOUBLE/REAL/DOUBLE PRECISION
		
		> 语法：FLOAT[精度]

3. 位串数据类型

- BIT
	> 语法：BIT

	> 用于存储整数数据 1、0 或 NULL，只有 0 才转换为假，其他非空、非 0值都会自动转换为真

4. 时间数据类型

5. 多媒体数据类型

- TEXT/LONGVARCHAR/IMAGE/BLOB/CLOB
	
	> 存储长度2G-1

## 表达式

1. 数值表达式