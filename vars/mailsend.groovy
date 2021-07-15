def call (Map stage) {
       
	   emailext (
	        to:  stage.to,
			body: stage.body,
			mimeType: 'text/html',
			subject: stage.sub,
			replyTo: '$DEFAULT_REPLYTO',
			attachmentsPattern: 'test.txt'
	   )
}
