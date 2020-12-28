#!/bin/bash

set -e

declare -ar PROJECT_NAMES=(
    "module_flutter" \
)

for PROJECT_NAME in "${PROJECT_NAMES[@]}"
do
    echo "== Testing '${PROJECT_NAME}' on Flutter's ${FLUTTER_VERSION} channel =="
    pushd "${PROJECT_NAME}"

    # Grab packages.
    flutter pub get

    # Run the analyzer to find any static analysis issues.
    flutter analyze

    # Reformat the web plugin registrant, if necessary.
    if [ -f "lib/generated_plugin_registrant.dart" ]
    then
        echo "Renaming $(pwd)/lib/generated_plugin_registrant.dart"
        flutter format "lib/generated_plugin_registrant.dart"
    fi

    # Run the formatter on all the dart files to make sure everything's linted.
    flutter format -n --set-exit-if-changed .

    # Run the actual tests.
    flutter test

    popd
done

echo "-- Success --"
