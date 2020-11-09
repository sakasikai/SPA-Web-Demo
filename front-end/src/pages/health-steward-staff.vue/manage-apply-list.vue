<template>
  <div class="q-pa-md">
    <q-table
      :data="data"
      :columns="columns"
      title="查看新申请项"
      :rows-per-page-options="[5, 10, 15, 20]"
      row-key="userName"
      :filter="filter"
    >
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
          <q-td key="ApplyNote" :props="props">
            {{ props.row.applyNote }}
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

          <q-td key="ApplyState" :props="props">
            <apply-state
              :userName="props.row.userName"
              :applyState="props.row.applyState"
              @click.native="showApplyTalkDialog(props.row.userName)"
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

    <!-- 申请要求 -->
    <!-- <apply-note /> -->

    <!-- 预约洽谈 -->
    <apply-talk-dialog
      :myOnApplyTalkDialog="onApplyTalkDialog"
      :userName="currentUserName"
      @myCloseApplyTalkDialog="closeApplyTalkDialog"
    />
  </div>
</template>

<script>
import { date } from "quasar";
import ClientDetails from "components/health-steward-tools/clientInfo-details";
import ApplyState from "components/health-steward-tools/apply-state";
import ApplyTalkDialog from "components/health-steward-tools/apply-talk-dialog";

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
    name: "ApplyNote",
    label: "申请要求",
    field: "applyNote"
  },
  {
    name: "UserInfo",
    label: "详细信息",
    field: "userInfo"
  },
  {
    // 包含两个状态： 可申请(等待医生选择)，不可申请(已有医生选择)
    // 后端要提供 原子性 API 使用注解：@Transactional
    // 申请时，先向后台测试，有没有锁，有的话申请失败，没有的话对该申请项上锁，申请成功
    name: "ApplyState",
    label: "申请状态",
    field: "applyState"
  }
];

export default {
  data() {
    return {
      currentUserName: "",
      onDetailsPannel: false,
      onApplyTalkDialog: false,
      filter: "",
      columns,
      data: [
        {
          userName: "Frozen Yogurt",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "leo",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "naro",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "Frozen Yogurt1",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 3
        },
        {
          userName: "leo1",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "naro1",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 5
        },
        {
          userName: "Frozen Yogurt2",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 4
        },
        {
          userName: "leo2",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "naro2",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 4
        },
        {
          userName: "Frozen Yogurt3",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 4
        },
        {
          userName: "leo3",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "naro3",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 3
        },
        {
          userName: "Frozen Yogurt4",
          nickName: "hao si",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "leo4",
          nickName: "hua zai",
          timeStamp: this.getMockTime2(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "naro4",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        },
        {
          userName: "naro5",
          nickName: "hahah",
          timeStamp: this.getMockTime1(),
          applyNote: "text-middle 200 words limited",
          applyState: 2
        }
      ]
    };
  },
  components: {
    ClientDetails,
    ApplyState,
    ApplyTalkDialog
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
    showApplyTalkDialog(userName) {
      this.onApplyTalkDialog = true;
      this.currentUserName = userName;
    },
    closeApplyTalkDialog() {
      this.onApplyTalkDialog = false;
    },
    getMockTime1() {
      let tmp = date.formatDate(Date.now(), "YYYY-MM-DD HH:MM:SS");
      return tmp;
    },
    getMockTime2() {
      let tmp = date.formatDate(Date.now(), "YYYY-MM-DD HH:MM:SS");
      return tmp;
    }
  }
};
</script>
