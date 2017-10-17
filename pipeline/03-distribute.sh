***REMOVED***

# Waking up herokuapp
curl $BACKOFFICE_URL > /dev/null
#if [ "$CI_BRANCH" == "DEVELOPE" ]; then
gradle bintrayUpload
#***REMOVED***
# ARTIFACTS:
# ARTIFACT build/libs
#
# ENVIRONMENT VARIABLES:
#   BACKOFFICE_URL https://backof***REMOVED***ce-qa.kushkipagos.com/