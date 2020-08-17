<template>
  <div>
    <v-container>
      <v-row :style="{ width: (lists.length + 1) * 350 + 'px' }">
        <v-col v-for="list in lists" :key="list.id">
          <List :list="list" />
        </v-col>
        <v-col>
          <v-card v-if="addMode">
            <v-card-title>
              <span>新規リスト</span>
            </v-card-title>
            <v-form ref="form" v-model="valid">
              <v-card-text>
                <v-text-field
                  label="タイトル*"
                  :counter="30"
                  :rules="titleRules"
                  required
                  v-model="title"
                ></v-text-field>
              </v-card-text>
              <v-card-actions>
                <v-btn @click="onCancel">キャンセル</v-btn>
                <v-btn :disabled="!valid" @click="onAdd">追加</v-btn>
              </v-card-actions>
            </v-form>
          </v-card>
          <v-btn v-else @click="onAddClick">リスト追加</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import List from "./List";
import { mapState } from "vuex";
import { postData, LIST_SELECT, LIST_CREATE } from "../common/API";
import { MUTATION_KEYS } from "../store";
export default {
  name: "Main",
  components: {
    List,
  },
  data() {
    return {
      addMode: false,
      valid: true,
      title: "",
      titleRules: [
        (v) => !!v || "入力してください",
        (v) => (v && v.length <= 30) || "30文字以内で入力して下さい",
      ],
    };
  },
  computed: mapState({
    lists: (state) => state.lists,
  }),
  async created() {
    //リスト情報取得
    const lists = await postData(LIST_SELECT);
    this.$store.commit(MUTATION_KEYS.SET_LISTS, lists);
  },
  methods: {
    onAddClick() {
      // リスト追加ボタンクリック時
      this.addMode = true;
    },
    onCancel() {
      // キャンセルボタンクリック時
      this.title = "";
      this.addMode = false;
      this.$refs.form.reset();
    },
    async onAdd() {
      // リスト追加処理
      const lists = await postData(LIST_CREATE, { title: this.title });
      this.title = "";
      this.addMode = false;
      this.$store.commit(MUTATION_KEYS.SET_LISTS, lists);
    },
  },
};
</script>
