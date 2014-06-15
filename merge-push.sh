rm -rf "c:/Users/Kevin Bowersox/Desktop/Development/Workspaces/STS Workspace 3.4/Archives/blog/"
cd "c:/Users/Kevin Bowersox/Desktop/Development/Workspaces/STS Workspace 3.4/blog/"
git checkout master
cp -r "c:/Users/Kevin Bowersox/Desktop/Development/Workspaces/STS Workspace 3.4/blog/" "c:/Users/Kevin Bowersox/Desktop/Development/Workspaces/STS Workspace 3.4/Archives/blog/"
git checkout github_master
sleep 10
git merge master --no-commit
git rm --cached -r .openshift
git rm --cached -r src/main/resources/META-INF/security
git rm --cached -r src/main/resources/META-INF/jobs
git rm --cached -r src/main/resources/META-INF/email
git rm --cached -r src/main/resources/META-INF/db
git rm --cached -r src/main/webapp/WEB-INF/spring/spring-data-context.xml
git clean -df
git commit -m "Finished Merge"
git push https://kmb385:shamrock2@github.com/kmb385/toThought.git github_master
read -p "Press [Enter] key to start backup..."