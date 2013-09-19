#!/bin/bash

##### Env variables ######################
export P4PORT=
export P4USER=
export P4PASSWD=
export P4CLIENT=
changes_found=0;
build_dir=/home/kjeyapra/workspace/megabus/build
cur_dir=${pwd}
. /home/kjeyapra/.bash_profile

##### Functions #######################
function check_scm_activity() 
{
  p4_sync_output=`p4 sync -n 2>&1`
  echo $p4_sync_output
  if [[ "$p4_sync_output" == *.xsd* ]]; then
    changes_found=1;
  else
    changes_found=0;
  fi
}

function sync_from_scm() {
  p4 sync
}

function check_out_file() {
  p4 edit $1  
}

function check_in_file() {
  p4 submit -d '<CC State="NotDone"><Comment>dev wsdl checkin</Comment><TTID Merge="False">APP53164</TTID><Hours>0</Hours><Reviewer/><Notify></Notify><RootC/><SCMInst></SCMInst><SQEInst></SQEInst><DBAInst></DBAInst><InterfacesChanged/></CC>' $1
}


##### Main Script #######################
check_scm_activity 
if [ "$changes_found" -eq 1 ]; then
  echo $(date)' - Changes found. Syncing files ..'
  sync_from_scm
  echo 'Building changes now ...'
  cd $build_dir
  ant -Denv=ide ide.war.deploy
  check_out_file /home/kjeyapra/workspace/megabus/wsdls/dev/BusService.wsdl
  check_out_file /home/kjeyapra/workspace/megabus/wsdls/dev/megabus-soap12.wsdl
  ant wsdl-soap12-dev;
  check_in_file /home/kjeyapra/workspace/megabus/wsdls/dev/BusService.wsdl
  check_in_file /home/kjeyapra/workspace/megabus/wsdls/dev/megabus-soap12.wsdl
  cd $cur_dir
else
  echo $(date)' - No changes found. Skipping build ..'
fi

