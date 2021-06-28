import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss']
})
export class QuizComponent implements OnInit {
  questions = [
    {
      statement: 'Qual das ferramentas a seguir foi criada pelo Facebook?',
      options: ['React', 'Vue', 'Angular', 'Svelte']
    },
    {
      statement:
        'Qual das ferramentas a seguir não é nem framework nem biblioteca, mas um compilador?',
      options: ['React', 'Vue', 'Angular', 'Svelte']
    },
    {
      statement: 'Qual das ferramentas a seguir é apoiada pelo Google?',
      options: ['React', 'Vue', 'Angular', 'Svelte']
    },
    {
      statement: 'Qual das ferramentas a seguir é usada no framework Nuxt.js?',
      options: ['React', 'Vue', 'Angular', 'Svelte']
    }
  ]
  current = 0
  answers: any = []
  mode = 'question'

  next() {
    if (this.current < this.questions.length - 1) {
      this.current++
    } else {
      this.mode = 'results'
    }
  }

  reset() {
    this.current = 0
    this.answers = []
    this.mode = 'question'
  }

  select(index: number) {
    this.answers[this.current] = index
    console.log(this.answers)
  }
  ngOnInit(): void {
  }

}
