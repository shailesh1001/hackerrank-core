@set CDBACKUP=%CD%
@cd %~dp0\..
@java -cp ".\lib\*;.\hackerrank.jar" jp.freepress.hackerrank.BetaSubmissionMain %*
@cd %CDBACKUP%
