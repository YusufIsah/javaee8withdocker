FROM payara/server-full:5-SNAPSHOT 

COPY  target/LearningJavaEE8.war $DEPLOY_DIR
CMD ["/bin/sh"]
