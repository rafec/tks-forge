# Regras de Negócio - Treinos TKS

## Objetivo

Este documento descreve todas as regras de funcionamento da comunidade Treinos TKS.

As regras aqui descritas devem servir como fonte de verdade para a implementação do sistema.

---

# Registro de Treinos

## BR-001 - Registro obrigatório

Para receber pontuação, o participante deve registrar o treino realizado.

---

## BR-002 - Comprovação

Todo registro deve possuir ao menos uma foto comprobatória.

Exemplos:

* Selfie na academia.
* Foto da esteira.
* Foto do relógio esportivo.
* Foto do ambiente de treino.

Não são aceitos vídeos.

---

## BR-003 - Validação

O registro poderá ser aprovado ou rejeitado por administradores.

---

## BR-004 - Múltiplos treinos no mesmo dia

Um participante pode registrar mais de um treino na mesma data.
A validação da legitimidade dos treinos é responsabilidade dos administradores.

Treinos considerados artificialmente fragmentados ou excessivamente próximos poderão ser rejeitados.

Exemplos:
- Musculação pela manhã e corrida à tarde: permitido.
- Corrida e vôlei realizados como parte da mesma atividade recreativa: poderá ser rejeitado.

---

# Pontuação

## BR-005 - Pontuação base

Cada treino aprovado concede 1 ponto.

---

## BR-006 - Independência da modalidade

A pontuação é igual independentemente da modalidade praticada.

Exemplos:
* Musculação.
* Corrida.
* Caminhada.
* Calistenia.

Todos concedem a mesma quantidade de pontos.

---

# Penalidades

## BR-007 - Inatividade

Após 3 dias válidos consecutivos sem registrar treino, o participante perde 1 ponto.

---

## BR-008A - Dias válidos para pontuação

Treinos realizados em qualquer dia da semana podem gerar pontos.

Incluindo domingos e feriados.

---

## BR-008B - Dias válidos para penalidade

Domingos e feriados nacionais do Brasil não são considerados para cálculo de penalidades por inatividade.

---

## BR-009 - Pontuação mínima

A pontuação poderá ser negativa.

---

# Streaks

## BR-010A - Dias válidos para streak

Domingos e feriados não interrompem uma streak.

A streak é composta apenas pelos dias válidos para treino.

---

## BR-011 - Quebra da streak

A streak é encerrada quando o participante deixa de cumprir os requisitos mínimos de continuidade.

---

## BR-012 - Recompensas

O sistema poderá conceder conquistas relacionadas a streaks.

---

# Conquistas

## BR-013 - Concessão

Conquistas são atribuídas automaticamente pelo sistema.

---

## BR-014 - Persistência

Uma conquista obtida não poderá ser perdida.

---

# Ranking

## BR-015 - Ordenação

O ranking principal é definido pela quantidade de pontos.

---

## BR-016 - Critério de desempate

Em caso de empate, utilizar:

1. Maior streak atual.
2. Data de entrada mais antiga.
3. Ordem alfabética.

---

# Expulsão

## BR-017 - Inatividade prolongada

Participantes com 3 semanas consecutivas sem treinar poderão ser submetidos à votação para remoção.

---

## BR-018 - Votação

A remoção de um participante depende de aprovação da maioria dos administradores.

---

# Administração

## BR-019 - Administradores

Administradores podem:
* Aprovar treinos.
* Rejeitar treinos.
* Corrigir registros.
* Aplicar ajustes manuais.

Administradores poderão suspender ou cancelar processos de remoção mediante justificativa plausível apresentada pelo participante.

---
## BR-020 - Retorno após remoção

Participantes removidos poderão solicitar retorno à comunidade.

Para retornar, deverão:

- Realizar 5 treinos consecutivos.
- Enviar as comprovações ao administrador.
- Ter os treinos aprovados.

Após aprovação:

- Retornam ao grupo.
- Recebem os pontos correspondentes aos treinos realizados.
- Recebem os benefícios associados à streak formada.

---
## BR-021 - Auditoria

Toda alteração administrativa deve gerar um evento auditável.

---

# Histórico

## BR-021 - Eventos

Toda alteração relevante deve gerar um evento.

Exemplos:

* Treino registrado.
* Treino aprovado.
* Ponto concedido.
* Penalidade aplicada.
* Conquista recebida.
* Expulsão.

---

## BR-022 - Imutabilidade

Eventos históricos não devem ser removidos.

Correções devem ser realizadas através de novos eventos.