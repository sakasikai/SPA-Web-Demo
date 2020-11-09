<template>
  <div>
    <div class="q-pa-md">
      <q-table
        :data="data"
        :columns="columns"
        title="管理用户"
        :rows-per-page-options="[5, 10, 15, 20]"
        row-key="userName"
        :filter="filter"
      >
        <template v-slot:top>
          <div class="row no-wrap items-center q-gutter-md">
            <q-img
              style="width: 50px"
              :ratio="1"
              class="rounded-borders"
              src="https://cdn.quasar.dev/img/donuts.png"
            />
            <q-btn
              rounded
              outline
              style="color: goldenrod"
              label="查看所有备注"
              @click="showStaffNoteAll()"
            />
          </div>

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
            <q-td key="SignedTimeStamp" :props="props">
              {{ props.row.signedTimeStamp }}
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
            <q-td key="RepealContract" :props="props">
              <q-btn
                flat
                rounded
                color="red"
                label="解除合约"
                @click="showContractPannel(props.row.userName)"
              />
            </q-td>
          </q-tr>
        </template>
      </q-table>
    </div>

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

    <repeal-contract
      :myOnRepealContract="onRepealContract"
      :userName="currentUserName"
      @myCloseContractPannel="closeContractPannel"
    />
  </div>
</template>

<script>
import ClientDetails from "components/health-steward-tools/clientInfo-details";
import StaffNotes from "components/health-steward-tools/staff-notes";
import RepealContract from "components/health-steward-tools/repeal-contract";
import { date } from "quasar";

const columns = [
  {
    name: "UserName",
    align: "left",
    label: "用户账号",
    field: "userName", // this is clientName
    sortable: true,
    sort: (a, b, rowA, rowB) => a - b
  },
  {
    name: "NickName",
    align: "center",
    label: "用户昵称",
    field: "nickName",
    sortable: true,
    sort: (a, b, rowA, rowB) => a - b
  },
  {
    name: "SignedTimeStamp",
    label: "合同生效时间",
    field: "signedTimeStamp",
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
    name: "RepealContract",
    label: "解除合约",
    field: "repealContract"
  }
];

export default {
  data() {
    return {
      currentUserName: "",
      onDetailsPannel: false,
      onStaffNote: false,
      noteType: "",
      onRepealContract: false,
      filter: "",
      columns,
      data: [
        {
          userName: "Frozen Yogurt",
          nickName: "201792111",
          signedTimeStamp: this.getMockTime1(),
          ifRepeal: false
        },
        {
          userName: "Ice cream sandwich",
          nickName: "201792123",
          signedTimeStamp: this.getMockTime1(),
          ifRepeal: false
        },
        {
          userName: "Eclair",
          nickName: "201792124",
          signedTimeStamp: this.getMockTime1(),
          ifRepeal: false
        },
        {
          userName: "Cupcake",
          nickName: "201792127",
          signedTimeStamp: this.getMockTime1(),
          ifRepeal: false
        }
      ]
    };
  },
  components: {
    ClientDetails,
    StaffNotes,
    RepealContract
  },
  methods: {
    showDetailsPannel(userName) {
      // 子组件通过v-bind绑定将下面参数传入
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
      this.noteType = "signedNote";
    },
    showStaffNoteAll() {
      // 子组件通过v-bind绑定将下面参数传入
      this.onStaffNote = true;
      this.currentUserName = "";
      this.noteType = "signedNote";
    },
    closeStaffNote() {
      this.onStaffNote = false;
    },
    showContractPannel(userName) {
      // 子组件通过v-bind绑定将下面参数传入
      this.onRepealContract = true;
      this.currentUserName = userName;
    },
    closeContractPannel() {
      this.onRepealContract = false;
    },
    getMockTime1() {
      let tmp = date.formatDate(Date.now(), "YYYY-MM-DD HH:MM:SS");
      return tmp;
    }
  }
};
</script>
