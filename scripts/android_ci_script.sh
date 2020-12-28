#!/bin/bash

set -e

echo "Fetching dependencies and building 'module_flutter'."
pushd module_flutter
flutter packages get
flutter build aar
popd

echo "== Testing General on Flutter's ${FLUTTER_VERSION} channel =="
pushd General

./scripts/recursive.sh clean assembleAlphaRelease

popd

echo "-- Success --"
