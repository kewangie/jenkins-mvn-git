#!/bin/sh

build_source="/data/servers/jenkins/.jenkins/jobs/LANA_SONAR/workspace"

build_destination="/data/fusion_dev_nw_forecasting/lana_builds"

build_artifacts_name_file="/data/servers/jenkins/cicd/build-artifacts-for-rm-cm.txt"

jar_file_used_to_get_build_timestamp="$build_source/api/target/lana-api-rest.jar"

build_timestamp=$(unzip -p $jar_file_used_to_get_build_timestamp META-INF/MANIFEST.MF | grep "Build-Timestamp" | cut -d' ' -f2)

build_destination_for_this_build="$build_destination/$build_timestamp"
build_destination_for_this_build=${build_destination_for_this_build%?}

rm -fr $build_destination_for_this_build
mkdir $build_destination_for_this_build

cat $build_artifacts_name_file | while read file_name
do
    echo "Copy $build_source/$file_name to $build_destination_for_this_build"
    cp "$build_source/$file_name" $build_destination_for_this_build
done

exit 0