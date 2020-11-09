<template>
  <div class="q-pa-md">
    <q-table
      :data="data"
      :columns="columns"
      title="管理洽谈项"
      :rows-per-page-options="[5, 10, 15, 20]"
      row-key="userName"
      :filter="filter"
    >
      <template v-slot:top>
        <q-btn color="primary" label="Placeholder" />
        <q-btn
          flat
          rounded
          color="purple"
          label="查看所有备注"
          @click="showStaffNoteAll()"
        />
        <q-space />
        <q-input
          dense
          debounce="300"
          color="primary"
          label="按用户名查找..."
          v-model="filter"
        >
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>
      </template>

      <template v-slot:body="props">
        <q-tr :props="props">
          <q-td key="UserName" :props="props">
            {{ props.row.userName }}
          </q-td>
          <q-td key="NickName" :props="props">
            {{ props.row.nickName }}
          </q-td>
          <q-td key="TimeStamp" :props="props">
            {{ props.row.timeStamp }}
          </q-td>

          <q-td key="UserInfo" :props="props">
            <q-btn
              flat
              rounded
              color="primary"
              label="详细信息"
              @click="showDetailsPannel(props.row.userName)"
            />
          </q-td>

          <q-td key="StaffNote" :props="props">
            <q-btn
              flat
              rounded
              color="primary"
              label="查看备注"
              @click="showStaffNote(props.row.userName)"
            />
          </q-td>

          <q-td key="StaffConfirm" :props="props">
            <staff-confirm-btn
              :clientName="props.row.userName"
              :staffConfirm="props.row.staffConfirm"
            />
          </q-td>

          <q-td key="ClientConfirm" :props="props">
            <client-confirm-btn
              :clientName="props.row.userName"
              :clientConfirm="props.row.clientConfirm"
            />
          </q-td>
          <!-- 每10s刷新，查询数据库判断状态，点击后要弹出通知并显示相关信息，提醒staff手动删除 -->
          <q-td key="ContractState" :props="props">
            <contract-state-btn
              :clientName="props.row.userName"
              :contractState="props.row.contractState"
              @click.native="showContractDialog(props.row.userName)"
            />
          </q-td>
        </q-tr>
      </template>
      <template v-slot:no-data></template>
    </q-table>

    <!-- 客户详细信息 -->
    <client-details
      :myOnDetailsPannel="onDetailsPannel"
      :userName="currentUserName"
      @myCloseDetailsPannel="closeDetailsPannel"
    />
    <!-- 医生备注 -->
    <staff-notes
      :myOnStaffNote="onStaffNote"
      :userName="currentUserName"
      :type="noteType"
      @myCloseStaffNote="closeStaffNote"
    />
    <!-- ContractState notify and delete -->
    <contract-state-dialog
      :myOnContractDialog="onContractDialog"
      :userName="currentUserName"
      @myCloseContractDialog="closeContractDialog"
    />
  </div>
</template>

<script>
import ClientDetails from "components/health-steward-tools/clientInfo-details";
import StaffNotes from "components/health-steward-tools/staff-notes";
import StaffConfirmBtn from "components/health-steward-tools/staff-confirm-btn";
import ClientConfirmBtn from "components/health-steward-tools/client-confirm-btn";
import ContractStateBtn from "components/health-steward-tools/contract-state-btn";
import ContractStateDialog from "components/health-steward-tools/contract-state-dialog";
import { date } from "quasar";

const columns = [
  {
    name: "UserName",
    align: "left",
    label: "账号",
    field: "userName", // this is clientName
    sortable: true,
    sort: (a, b, rowA, rowB) => a - b
  },
  {
    name: "NickName",
    align: "center",
    label: "用户名",
    field: "nickName",
    sortable: true,
    sort: (a, b, rowA, rowB) => a - b
  },
  {
    name: "TimeStamp",
    label: "申请创建时间",
    field: "timeStamp",
    sortable: true
    // sort: (a, b, rowA, rowB) =>
  },
  {
    name: "UserInfo",
    label: "详细信息",
    field: "userInfo"
  },
  {
    name: "StaffNote",
    label: "备注",
    field: "staffNote"
  },
  {
    name: "StaffConfirm",
    label: "医生是否同意签约",
    field: "staffConfirm"
  },
  {
    name: "ClientConfirm",
    label: "客户是否同意签约",
    field: "clientConfirm"
  },
  {
    name: "ContractState",
    label: "合约状态",
    field: "contractState"
  }
];

export default {
  data() {
    return {
      currentUserName: "",
      onDetailsPannel: false,
      onStaffNote: false,
      noteType: "",
      onContractDialog: false,
      filter: "",
      columns,
      data: [
        {
          userName: "Frozen Yogurt",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 2,
          contractState: 1
        },
        {
          userName: "leo",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          staffConfirm: 0,
          clientConfirm: 1,
          contractState: 2
        },
        {
          userName: "naro",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 0,
          contractState: 0
        },
        {
          userName: "Frozen Yogurt1",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 2,
          contractState: 1
        },
        {
          userName: "leo1",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          staffConfirm: 0,
          clientConfirm: 1,
          contractState: 2
        },
        {
          userName: "naro1",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 0,
          contractState: 0
        },
        {
          userName: "Frozen Yogurt2",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 2,
          contractState: 1
        },
        {
          userName: "leo2",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          staffConfirm: 0,
          clientConfirm: 1,
          contractState: 2
        },
        {
          userName: "naro2",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 0,
          contractState: 0
        },
        {
          userName: "Frozen Yogurt3",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 2,
          contractState: 1
        },
        {
          userName: "leo3",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          staffConfirm: 0,
          clientConfirm: 1,
          contractState: 2
        },
        {
          userName: "naro3",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 0,
          contractState: 0
        },
        {
          userName: "Frozen Yogurt4",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 2,
          contractState: 1
        },
        {
          userName: "leo4",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          staffConfirm: 0,
          clientConfirm: 1,
          contractState: 2
        },
        {
          userName: "naro4",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 0,
          contractState: 0
        },
        {
          userName: "naro5",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          staffConfirm: 0,
          clientConfirm: 0,
          contractState: 0
        }
      ]
    };
  },
  components: {
    ClientDetails,
    StaffNotes,
    StaffConfirmBtn,
    ClientConfirmBtn,
    ContractStateBtn,
    ContractStateDialog
  },
  methods: {
    showDetailsPannel(userName) {
      // 查看医生所有TalkingNote
      this.onDetailsPannel = true;
      this.currentUserName = userName;
    },
    closeDetailsPannel() {
      this.onDetailsPannel = false;
    },
    showStaffNote(userName) {
      // 子组件通过v-bind绑定将下面参数传入
      this.onStaffNote = true;
      this.currentUserName = userName;
      this.noteType = "talkingNote";
    },
    showStaffNoteAll() {
      // 子组件通过v-bind绑定将下面参数传入
      this.onStaffNote = true;
      this.currentUserName = "";
      this.noteType = "talkingNote";
    },
    closeStaffNote() {
      this.onStaffNote = false;
    },
    showContractDialog(userName) {
      this.onContractDialog = true;
      this.currentUserName = userName;
    },
    closeContractDialog() {
      this.onContractDialog = false;
    },
    getMockTime1() {
      let tmp = date.formatDate(Date.now(), "YYYY-MM-DD HH:MM:SS");
      return tmp;
    },
    getMockTime2() {
      // let newDate = new Date(2017, 2, 7);

      // newDate = date.addToDate(newDate, { days: 7, months: 1 });
      // // `newDate ` 现在是 2017-3-14 00:00:00

      // newDate = date.subtractFromDate(newDate, {
      //   hours: 24,
      //   milliseconds: 10000
      // });
      // // `newDate ` 现在是 2017-3-12 23:59:50
      // return newDate;
      let tmp = date.formatDate(Date.now(), "YYYY-MM-DD HH:MM:SS");
      return tmp;
    }
  }
};
</script>
