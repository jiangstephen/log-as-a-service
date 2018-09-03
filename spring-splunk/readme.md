Prerequisite to use this project
1. Splunk should have been installed
2. The splunk should have enough memory to run
3. The splunk should have enough diskspace to run the indexing
4. Configure the splunk data model using the TCP + port
5. Add the splunk tcp appender into the logback 

	<appender name="socket" class="com.splunk.logging.TcpAppender">
		<remoteHost>sjiang-vm</remoteHost>
		<port>15000</port>
		<layout class="ch.qos.logback.classic.PatternLayout">
		<pattern>%date{ISO8601} [%thread] %level: %msg%n</pattern>
		</layout>
	</appender>