***REMOVED***
cp build/libs/Kushki.jar out/artifacts/Kushki_jar/Kushki-$SNAP_PIPELINE_COUNTER.jar
cp build/libs/Kushki.jar out/artifacts/Kushki_jar/Kushki.jar
git add out/artifacts/Kushki_jar/
git commit -m '[snap-ci] adding latest version of jar, pipeline '$SNAP_PIPELINE_COUNTER
git con***REMOVED***g --global push.default simple
git pull --rebase
git push