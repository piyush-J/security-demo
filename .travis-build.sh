#!/bin/bash

# Split $TRAVIS_REPO_SLUG into the owner and repository parts
OIFS=$IFS
IFS='/'
read -r -a slugarray <<< "$TRAVIS_REPO_SLUG"
SLUGOWNER=${slugarray[0]}
SLUGREPO=${slugarray[1]}
IFS=$OIFS

export REPO_SITE=$SLUGOWNER

. ./setup.sh

. ./test-security.sh travis
